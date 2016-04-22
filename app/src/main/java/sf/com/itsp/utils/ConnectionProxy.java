package sf.com.itsp.utils;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Order;
import sf.com.itsp.domain.ServerAddress;
import sf.com.itsp.domain.Vehicle;

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

    public List<Order> requestOrder(Context context) {
        return (List<Order>) Orders.request(context);
    }

    public List<Vehicle> requestVehicle(Context context) {
        return (List<Vehicle>) Vehicles.request(context);
    }

    public List<Driver> requestDriver(Context context) {
        return (List<Driver>) Drivers.request(context);
    }

    public enum RequestPath {
        Orders("orders", Order[].class),
        Drivers("drivers", Driver[].class),
        Vehicles("vehicles", Vehicle[].class);

        private final String path;
        private final TypeToken typeToken;

        RequestPath(String path, Class clazz) {
            this.path = path;
            this.typeToken = TypeToken.get(clazz);
        }

        public List<?> request(Context context) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            String request = new HttpClient(serverAddress.host, serverAddress.port).request(path);

            return convert(request);
        }

        public List<?> convert(String dataAsJson) {
            return JsonConverter.jsonFromObjectList(dataAsJson, typeToken);
        }
    }
}