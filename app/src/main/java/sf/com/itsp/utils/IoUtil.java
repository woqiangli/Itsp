package sf.com.itsp.utils;

import java.net.HttpURLConnection;

public class IoUtil {
    public static void disconnectQuietly(HttpURLConnection connection) {
        if (connection == null) return;
        connection.disconnect();
    }
}
