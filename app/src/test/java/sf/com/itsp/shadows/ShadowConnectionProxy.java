package sf.com.itsp.shadows;

import android.content.Context;

import org.robolectric.annotation.Implements;

import java.util.List;

import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Order;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.utils.ConnectionProxy;

import static com.google.common.collect.Lists.newArrayList;

@Implements(ConnectionProxy.class)
public class ShadowConnectionProxy {
    private static List<Order> orders = newArrayList();
    private static List<Driver> drivers = newArrayList();
    private static List<Vehicle> vehicles = newArrayList();

    public static void clearAll() {
        orders = newArrayList();
        vehicles = newArrayList();
        drivers = newArrayList();
    }

    public static void fakeOrders(List<Order> fakedOrders) {
        orders = fakedOrders;
    }

    public static void fakeDrivers(List<Driver> fakedDrivers) {
        drivers = fakedDrivers;
    }

    public static void fakeVehicles(List<Vehicle> fakeVehicles) {
        vehicles = fakeVehicles;
    }

    public List<Order> requestOrder(Context context) {
        return orders;
    }

    public List<Driver> requestDriver(Context context) {
        return drivers;
    }

    public List<Vehicle> requestVehicle(Context context) {
        return vehicles;
    }

}