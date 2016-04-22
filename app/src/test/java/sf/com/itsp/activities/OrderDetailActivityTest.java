package sf.com.itsp.activities;

import android.content.Intent;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.util.ActivityController;

import java.util.ArrayList;
import java.util.List;

import sf.com.itsp.BasicTestRunner;
import sf.com.itsp.BuildConfig;
import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.orderDetail.HorizontalListView;
import sf.com.itsp.shadows.ShadowConnectionProxy;
import sf.com.itsp.vehicle.VehicleModel;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.shadows.ShadowApplication.runBackgroundTasks;
import static sf.com.itsp.testHelper.condition.HorizontalListItemCondition.numberOfItems;
import static sf.com.itsp.utils.DriverProvider.mockDriverResponse;

@RunWith(BasicTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 17, shadows = {ShadowConnectionProxy.class})
public class OrderDetailActivityTest {
    @After
    public void teardown() {
        ShadowConnectionProxy.clearAll();
    }

    @Test
    public void should_display_order_line_on_order_detail_activity() {
        // given
        initOrderDetailActivity();

        // when
        //TextView originView = (TextView) orderDetailActivity.findViewById(R.id.origin_view);
        //TextView targetView = (TextView) orderDetailActivity.findViewById(R.id.target_view);

        // then
        //assertThat(originView).has(text("755A"));
        //assertThat(targetView).has(text("755B"));
    }

    @Test
    public void should_display_vehicle_data_from_service() {
        List<Vehicle> vehicles = initVehicles();
        ShadowConnectionProxy.setVehicleList(vehicles);

        // given
        OrderDetailActivity orderDetailActivity = initOrderDetailActivity();
        com.meetme.android.horizontallistview.HorizontalListView vehicleList = (com.meetme.android.horizontallistview.HorizontalListView) orderDetailActivity.findViewById(R.id.vehicle_list);

        // when
        int index = 0;
        VehicleModel vehicleModel = (VehicleModel) vehicleList.getAdapter().getItem(index);

        // then
        Assertions.assertThat(vehicleModel.getVehicle().getNumber()).isEqualTo(vehicles.get(index).getNumber());
    }

    private List<Vehicle> initVehicles() {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        for (int i = 0; i < 20; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber("number" + i);
            vehicle.setPhoto(2130837504);
            vehicles.add(vehicle);
        }
        return vehicles;
    }

    private OrderDetailActivity initOrderDetailActivity() {
        Order mockOrder = generateOrder("755A", "755B");

        Intent newIntent = new Intent(ShadowApplication.getInstance().getApplicationContext(), MainActivity.class);
        newIntent.putExtra("order", mockOrder);

        OrderDetailActivity orderDetailActivity = buildActivity(OrderDetailActivity.class)
                .withIntent(newIntent)
                .create()
                .get();
        return orderDetailActivity;
    }

    private Order generateOrder(String original, String target) {
        Order mockOrder = mock(Order.class);
        when(mockOrder.getOriginal()).thenReturn(original);
        when(mockOrder.getTarget()).thenReturn(target);
        return mockOrder;
    }

    @Test
    public void should_display_drivers_on_order_detail_activity() {
        // given
        mockDriverResponse();

        ActivityController<OrderDetailActivity> orderDetailActivityActivityController = Robolectric.buildActivity(OrderDetailActivity.class);

        // when
        orderDetailActivityActivityController.create();
        OrderDetailActivity orderDetailActivity = orderDetailActivityActivityController.get();
        HorizontalListView driverListView = (HorizontalListView) orderDetailActivity.findViewById(R.id.driver_image_list);
        runBackgroundTasks();

        // then
        assertThat(driverListView).has(numberOfItems(3));
    }
}