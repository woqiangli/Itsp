package sf.com.itsp;

import android.widget.ListView;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testCondition.ContainsTextCondition.text;
import static sf.com.itsp.testCondition.ListViewChildCondition.childWith;
import static sf.com.itsp.testCondition.ListViewContainsItemsCondition.numberOfItems;
import static sf.com.itsp.utils.TaskProvider.mockTaskResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {
    @After
    public void teardown() {
        ShadowConnectionProxy.clearTasks();
    }

    @Test
    @Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
    public void should_show_tasks_when_on_created() {
        //given
        mockTaskResponse();
        ActivityController<MainActivity> mainActivityController = buildActivity(MainActivity.class);
        MainActivity mainActivity = mainActivityController.get();

        //when
        mainActivityController.create();
        ListView listView = (ListView) mainActivity.findViewById(R.id.task_list);
        runBackgroundTasks();

        //then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("深圳市中转场")));
        assertThat(listView).has(childWith(text("长沙中转场")));

        assertThat(listView).has(childWith(text("装车")));
        assertThat(listView).has(childWith(text("卸车")));
    }
}