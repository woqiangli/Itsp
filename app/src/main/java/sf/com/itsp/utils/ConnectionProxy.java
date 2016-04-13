package sf.com.itsp.utils;

import android.content.Context;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.ServerAddress;

public class ConnectionProxy {
    private static ConnectionProxy instance;

    public static ConnectionProxy getInstance() {
        if (instance == null) {
            instance = new ConnectionProxy();
        }
        return instance;
    }

    private ConnectionProxy() {

    }

    public String requestOrder(Context context) {
        ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
//        return new HttpClient(serverAddress.host, serverAddress.port).request("/orders");
        return "[\n" +
                "  {\n" +
                "    'original': '755A',\n" +
                "    'target': '020A',\n" +
                "    'vehicleType': '货柜车',\n" +
                "    'startDate': '2016-03-11',\n" +
                "    'endDate': '2016-03-14',\n" +
                "    'weight': 2,\n" +
                "    'vehicleAge': 3\n" +
                "  },\n" +
                "  {\n" +
                "    'original': '754A',\n" +
                "    'target': '021A',\n" +
                "    'vehicleType': '货柜车2',\n" +
                "    'startDate': '2016-03-11',\n" +
                "    'endDate': '2016-03-14',\n" +
                "    'weight': 1,\n" +
                "    'vehicleAge': 4\n" +
                "  }\n" +
                "]";
    }
}