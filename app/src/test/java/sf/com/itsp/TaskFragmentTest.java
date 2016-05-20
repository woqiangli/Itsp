package sf.com.itsp;

import android.support.v7.widget.CardView;
import android.widget.ListView;
import android.widget.TextView;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import sf.com.itsp.fragment.TaskFragment;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testCondition.ContainsTextCondition.text;
import static sf.com.itsp.testCondition.ListViewChildCondition.childWith;
import static sf.com.itsp.testCondition.ListViewContainsItemsCondition.numberOfItems;
import static sf.com.itsp.utils.TaskProvider.mockTaskResponse;
import static sf.com.itsp.utils.VehicleProvider.mockVehicleResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
public class TaskFragmentTest {
    @After
    public void teardown() {
        ShadowConnectionProxy.clearAll();
    }

    @Test
    public void should_show_tasks_when_on_created() {
        //given
        mockTaskResponse();
        TaskFragment taskFragment = new TaskFragment();
        SupportFragmentTestUtil.startFragment(taskFragment);

        //when
        ListView listView = (ListView) taskFragment.getView().findViewById(R.id.task_list);
        runBackgroundTasks();

        //then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("深圳市中转场")));
        assertThat(listView).has(childWith(text("长沙中转场")));

        assertThat(listView).has(childWith(text("装车")));
        assertThat(listView).has(childWith(text("卸车")));

        assertThat(listView).has(childWith(text("10:00")));
        assertThat(listView).has(childWith(text("24:00")));

        assertThat(listView).has(childWith(text("10:30")));

        assertThat(listView).has(childWith(text(120)));
        assertThat(listView).has(childWith(text(30)));

        assertThat(listView).has(childWith(text("始发")));
        assertThat(listView).has(childWith(text("经停")));
    }

    @Test
    public void should_display_vehicle_number_on_task_fragment() {
        //given
        mockVehicleResponse();
        TaskFragment taskFragment = new TaskFragment();

        //when
        SupportFragmentTestUtil.startFragment(taskFragment);
        CardView cardViewText = (CardView) taskFragment.getView().findViewById(R.id.mission_info);
        TextView vehicleNumber = (TextView) taskFragment.getView().findViewById(R.id.vehicle_number);
        runBackgroundTasks();

        //then
        assertThat(cardViewText).has(text("车牌号码"));
        assertThat(vehicleNumber).has(text("粤A-123456"));
    }
}
