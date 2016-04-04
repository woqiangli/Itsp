package sf.com.itsp.utils;

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

    public String requestOrder() {
        return "";
    }
}