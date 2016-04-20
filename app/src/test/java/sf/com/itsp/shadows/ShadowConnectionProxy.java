package sf.com.itsp.shadows;

import android.content.Context;

import org.robolectric.annotation.Implements;

import java.util.List;

import sf.com.itsp.domain.Order;
import sf.com.itsp.utils.ConnectionProxy;

import static com.google.common.collect.Lists.newArrayList;

@Implements(ConnectionProxy.class)
public class ShadowConnectionProxy {

    private static List<Order> orders = newArrayList();

    public List<Order> requestOrder(Context context) {
        return orders;
    }

    public static void fakeOrders(List<Order> fakedOrders) {
        orders = fakedOrders;
    }

    public static void clearOrders() {
        orders = newArrayList();
    }
}