package sf.com.itsp;

import android.widget.ListView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import sf.com.itsp.shadows.ShadowConnectionProxy;
import sf.com.testUtil.BasicTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.testUtil.condition.ContainsTextCondition.text;
import static sf.com.testUtil.condition.ListViewChildCondition.childWith;
import static sf.com.testUtil.condition.ListViewContainsItemsCondition.numberOfItems;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    @Config(shadows = {ShadowConnectionProxy.class})
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