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
        return new HttpClient(serverAddress.host, serverAddress.port).request("/orders");
    }

    public String requestDriver(Context context) {
        ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
        return new HttpClient(serverAddress.host, serverAddress.port).request("/drivers");
    }
}