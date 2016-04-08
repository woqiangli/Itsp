package sf.com.itsp.utils;

import sf.com.itsp.shadows.ShadowConnectionProxy;

public class OrderProvider {
    public static void mockEmptyOrderResponse() {
        ShadowConnectionProxy.clearOrders();
    }

    public static void mockOrderResponse() {
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
