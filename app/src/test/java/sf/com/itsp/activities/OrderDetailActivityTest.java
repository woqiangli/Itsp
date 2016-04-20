package sf.com.itsp.activities;

import android.content.Intent;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.util.ActivityController;

import sf.com.itsp.BasicTestRunner;
import sf.com.itsp.BuildConfig;
import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.orderDetail.HorizontalListView;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testHelper.condition.ListViewContainsItemsCondition.numberOfItems;
import static sf.com.itsp.utils.DriverProvider.mockDriverResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
public class OrderDetailActivityTest {
    @After
    public void teardown() {
        ShadowConnectionProxy.clearDrivers();
    }

    @Test
    public void should_display_order_line_on_order_detail_activity() {
        // given
        Order mockOrder = generateOrder("755A", "755B");

        Intent newIntent = new Intent(ShadowApplication.getInstance().getApplicationContext(), MainActivity.class);
        newIntent.putExtra("order", mockOrder);

        OrderDetailActivity orderDetailActivity = buildActivity(OrderDetailActivity.class)
                .withIntent(newIntent)
                .create()
                .get();

        // when
       //TextView originView = (TextView) orderDetailActivity.findViewById(R.id.origin_view);
        //TextView targetView = (TextView) orderDetailActivity.findViewById(R.id.target_view);

        // then
        //assertThat(originView).has(text("755A"));
        //assertThat(targetView).has(text("755B"));
    }

    private Order generateOrder(String original, String target) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getOriginal()).thenReturn(original);
        when(mockOrder.getTarget()).thenReturn(target);
        return mockOrder;
    }

    @Test
    public void should_display_drivers_on_order_detail_activity() {
        //given
        mockDriverResponse();
        ActivityController<OrderDetailActivity> orderDetailActivityActivityController = buildActivity(OrderDetailActivity.class);
        OrderDetailActivity orderDetailActivity = orderDetailActivityActivityController.get();
        
        //when
        orderDetailActivityActivityController.create();
        HorizontalListView driverListView = (HorizontalListView) orderDetailActivity.findViewById(R.id.driver_image_list);
        runBackgroundTasks();

        //then
        assertThat(driverListView).has(numberOfItems(3));
    }

//    @Test
//    public void should_display_vehicles_on_order_detail_activity() {
//        //given
//        mockVehicleResponse();
//        ActivityController<OrderDetailActivity> orderDetailActivityActivityController = buildActivity(OrderDetailActivity.class);
//        OrderDetailActivity orderDetailActivity = orderDetailActivityActivityController.get();
//
//        //when
//        orderDetailActivityActivityController.create();
//        HorizontalListView vehicleListView = (HorizontalListView) orderDetailActivity.findViewById(R.id.vehicle_list);
//
//        //then
//        assertThat(vehicleListView).has(childWith(text("1")));
//    }
}