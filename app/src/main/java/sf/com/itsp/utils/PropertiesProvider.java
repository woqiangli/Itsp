package sf.com.itsp.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sf.com.itsp.R;
import sf.com.itsp.domain.ServerAddress;

public class PropertiesProvider {
    public static final String KEY_SERVER_HOST = "server_host";
    public static final String DEFAULT_SERVER_HOST = "";
    public static final String KEY_SERVER_PORT = "server_port";
    public static final String DEFAULT_PORT = "0";
    private Properties properties;
    private static PropertiesProvider instance;

    private PropertiesProvider(Context context) {
        init(context);
    }

    private void init(Context context) {
        InputStream inputStream = context.getResources().openRawResource(R.raw.app_config);

        properties = new Properties();

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesProvider getInstance(Context context) {
        if (instance == null) {
            instance = new PropertiesProvider(context);
        }

        return instance;
    }

    public ServerAddress getServerAddress() {
        return new ServerAddress(getServerHost(), getServerPort());
    }

    private String getServerHost() {
        return properties.getProperty(KEY_SERVER_HOST, DEFAULT_SERVER_HOST);
    }

    private int getServerPort() {
        return Integer.valueOf(properties.getProperty(KEY_SERVER_PORT, DEFAULT_PORT));
    }
}
