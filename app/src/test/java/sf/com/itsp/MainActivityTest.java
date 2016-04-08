package sf.com.itsp;

import android.content.Intent;
import android.widget.ListView;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.util.ActivityController;

import sf.com.itsp.shadows.ShadowConnectionProxy;
import sf.com.testUtil.BasicTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Shadows.shadowOf;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.testUtil.condition.ContainsTextCondition.text;
import static sf.com.testUtil.condition.ListViewChildCondition.childWith;
import static sf.com.testUtil.condition.ListViewContainsItemsCondition.numberOfItems;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, shadows = {ShadowConnectionProxy.class})
public class MainActivityTest {

    @After
    public void teardown() {
        ShadowConnectionProxy.clearOrders();
    }

    @Test
    public void should_show_orders_when_on_created() {
        // given
        mockOrderResponse();
        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class);
        MainActivity mainActivity = mainActivityActivityController.get();

        // when
        mainActivityActivityController.create();
        ListView listView = (ListView) mainActivity.findViewById(R.id.order_list);
        runBackgroundTasks();

        // then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("original2 -- target2")));
        assertThat(listView).has(childWith(text("2.0")));
        assertThat(listView).has(childWith(text("车型2")));
        assertThat(listView).has(childWith(text("2")));
        assertThat(listView).has(childWith(text("2016-04-03 -- 2016-04-06")));
    }

    @Test
    public void should_goto_specify_order_detail_activity_when_click_item_on_list_view() {
        // given
        mockEmptyOrderFromProxyResponse();

        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class).create();
        MainActivity mainActivity = mainActivityActivityController.get();

        ListView orderListView = (ListView) mainActivity.findViewById(R.id.order_list);

        // when
        orderListView.performItemClick(null, 1, 0);

        // then
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        String expectActivityClassName = shadowActivity.getNextStartedActivity().getComponent().getClassName();
        assertThat(expectActivityClassName).isEqualTo(OrderDetailActivity.class.getName());
    }

    private void mockEmptyOrderFromProxyResponse() {

    }

    @Test
    public void should_do_nothing_when_click_list_view_without_any_data() {
        // given
        mockOrderResponse();

        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class).create();
        MainActivity mainActivity = mainActivityActivityController.get();

        ListView orderListView = (ListView) mainActivity.findViewById(R.id.order_list);

        // when
        orderListView.performItemClick(null, 1, 0);

        // then
        ShadowActivity shadowActivity = shadowOf(mainActivity);
        Intent expectIntent = shadowActivity.getNextStartedActivity();
        assertThat(expectIntent).isNull();
    }

    private void mockOrderResponse() {
        ShadowConnectionProxy.orders = "[\n" +
                "    {\n" +
                "        'original': 'original1',\n" +
                "        'target': 'target1',\n" +
                "        'weight': 2.0,\n" +
                "        'vehicleType': '车型'," +
                "        'vehicleAge': 1," +
                "        'startDate': '2016-04-03'," +
                "        'endDate': '2016-04-05'" +
                "    },\n" +
                "    {\n" +
                "        'original': 'original2',\n" +
                "        'target': 'target2',\n" +
                "        'weight': 2.0,\n" +
                "        'vehicleType': '车型2'," +
                "        'vehicleAge': 2," +
                "        'startDate': '2016-04-03'," +
                "        'endDate': '2016-04-06'" +
                "    }\n" +
                "]";
    }
}