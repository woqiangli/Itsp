package sf.com.itsp.testHelper.condition;

import android.app.Activity;
import android.content.Intent;

import org.fest.assertions.core.Condition;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowIntent;

import java.io.Serializable;

import static org.robolectric.Shadows.shadowOf;

public class ActivityStartedCondition extends Condition<Activity> {

    private final String expectedActivityName;
    private ShadowIntent shadowIntent;
    private String actualActivityName;

    public ActivityStartedCondition(Class expectedActivityClass) {
        expectedActivityName = expectedActivityClass.getName();
    }

    @Override
    public boolean matches(Activity activity) {
        Intent nextStartedActivity = shadowOf(activity).getNextStartedActivity();

        shadowIntent = shadowOf(nextStartedActivity);
        actualActivityName = shadowIntent.getIntentClass().getName();
        describedAs("\nexpected\n" + expectedActivityName + "\nbut actual\n" + actualActivityName + "\n");

        return expectedActivityName.equals(actualActivityName);
    }

    public ShadowIntent getIntent() {
        return shadowIntent;
    }

    public static ActivityStartedCondition startedActivity(Class expectedActivityClass) {
        return new ActivityStartedCondition(expectedActivityClass);
    }

    public WithSerializableData withSerializableData(String name, Serializable expectedValue) {
        return new WithSerializableData(this, name, expectedValue);
    }

    public class WithSerializableData extends Condition<Activity> {

        private final ActivityStartedCondition parentCondition;
        private final String name;
        private final Serializable expectedValue;

        public WithSerializableData(ActivityStartedCondition parentCondition, String name, Serializable expectedValue) {
            this.parentCondition = parentCondition;
            this.name = name;
            this.expectedValue = expectedValue;
        }

        @Override
        public boolean matches(Activity activity) {
            if (!parentCondition.matches(activity)) {
                return false;
            }

            Serializable data = parentCondition.getIntent().getSerializableExtra(name);
            if (data != expectedValue && !expectedValue.equals(data)) {
                describedAs("\nthe value expected " + expectedValue + "\nactual " + data + "\n");
                return false;
            }

            return true;
        }
    }
}