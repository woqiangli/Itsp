package sf.com.itsp;

import android.widget.ListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowPaint;
import org.robolectric.util.ActivityController;

import sf.com.itsp.shadows.ShadowApiProxy;
import sf.com.itsp.shadows.ShadowConnectionProxy;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.testUtil.BasicTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static sf.com.testUtil.condition.ContainsTextCondition.text;
import static sf.com.testUtil.condition.ListViewChildCondition.childWith;
import static sf.com.testUtil.condition.ListViewContainsItemsCondition.numberOfItems;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class,
        shadows = {ShadowApiProxy.class})
public class MainActivityTest {

    @Before
    public void setup() {
    }

    @After
    public void teardown() {
    }

    @Test
    @Config(shadows = {ShadowConnectionProxy.class})
    public void should_show_orders_when_on_created() {
        // given
        ShadowConnectionProxy.orders = "123";
        ActivityController<MainActivity> mainActivityActivityController = buildActivity(MainActivity.class);
        MainActivity mainActivity = mainActivityActivityController.get();

        // when
        mainActivityActivityController.create();

        ListView listView = (ListView) mainActivity.findViewById(R.id.order_list);

        // then
        System.out.println("listView.getCount()" + listView.getCount());


        assertThat(listView).has(numberOfItems(2));
        assertThat(listView).has(childWith(text("shenzhen2 -- guangzhuo2")));
        assertThat(listView).has(childWith(text("2.0")));
    }
}