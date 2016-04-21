package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Order;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeOrders;

public class OrderProvider {
    public static final String ORDERS = "[\n" +
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

    public static void mockEmptyOrderResponse() {
        ShadowConnectionProxy.clearAll();
    }

    public static void mockOrderResponse() {
        fakeOrders(JsonConverter.<Order>jsonFromObjectList(ORDERS, TypeToken.get(Order[].class)));
    }
}
