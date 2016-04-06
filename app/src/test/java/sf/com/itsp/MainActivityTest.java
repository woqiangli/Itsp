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

        // then
        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("original2 -- target2")));
        assertThat(listView).has(childWith(text("2.0")));
    }

    private void mockOrderResponse() {
        ShadowConnectionProxy.orders = "[{'original':'original1','target':'target1','weight':2.0},{'original':'original2','target':'target2','weight':2.0}]";
    }
}