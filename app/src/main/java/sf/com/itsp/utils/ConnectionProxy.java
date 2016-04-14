package sf.com.itsp.utils;

import android.content.Context;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.ServerAddress;

import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Drivers;
import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Orders;
import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Vehicles;

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
        return Orders.request(context);
    }

    public String requestVehicleList(Context context) {
        return Vehicles.request(context);
    }

    public String requestDriver(Context context) {
        return Drivers.request(context);
    }

    public enum RequestPath {
        Orders("orders"),
        Vehicles("vehicles"),
        Drivers("drivers");

        private final String path;

        RequestPath(String path) {
            this.path = path;
        }

        public String request(Context context) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            return new HttpClient(serverAddress.host, serverAddress.port).request(path);
        }
    }
}