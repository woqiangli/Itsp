package sf.com.itsp.testHelper.condition;

import android.view.View;
import android.view.ViewGroup;

import org.fest.assertions.core.Condition;

public abstract class ViewContainsItemsCondition extends Condition<View> {
    private final int numberOfItems;

    public ViewContainsItemsCondition(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean matches(View view) {
        int count = getCount((ViewGroup)view);
        describedAs("\nexpected has " + numberOfItems + " items but was " + count + "\n");
        return count == numberOfItems;
    }

    protected abstract int getCount(ViewGroup listView);

}