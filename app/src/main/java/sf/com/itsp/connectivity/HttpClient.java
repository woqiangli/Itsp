package sf.com.itsp.connectivity;

import android.os.Build;

import com.google.common.io.CharStreams;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sf.com.itsp.connectivity.ResponseResult.ResponseResultType;
import sf.com.itsp.domain.Order;
import sf.com.itsp.utils.IoUtil;

import static java.lang.String.format;
import static java.net.HttpURLConnection.HTTP_INTERNAL_ERROR;
import static java.net.HttpURLConnection.HTTP_OK;
import static sf.com.itsp.connectivity.ResponseResult.ResponseResultType.FAILED;
import static sf.com.itsp.connectivity.ResponseResult.ResponseResultType.SUCCEEDED;
import static sf.com.itsp.utils.IoUtil.disconnectQuietly;

public class HttpClient {
    private String HEADER_CONTENT_TYPE = "Content-Type";
    private String VALUE_APPLICATION_JSON = "application/json";
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF8");
    private static final int CONNECT_TIMEOUT_MILLIS = 30 * 1000;
    private static final int READ_TIMEOUT_MILLIS = 35 * 1000;

    private static final String DEFAULT_PROTOCOL = "http";

    private String host;
    private int port;

    private Map<String, String> propertiesMap = new HashMap<String, String>();

    public HttpClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public HttpResponseResult sendRequestGetResponse(String path, String request) {
        HttpURLConnection connection = null;
        try {
            connection = initConnection(path);
            send(request, connection);
            return receive(connection, path);
        } catch (Exception e) {
            return HttpResponseResult.RESPONSE_EXCEPTION_RESULT;
        } finally {
            disconnectQuietly(connection);
        }
    }

    public HttpResponseResult getResponse(String path) {
        return sendRequestGetResponse(path, "");
    }

    private HttpResponseResult receive(HttpURLConnection connection, String path) throws IOException {
        int responseCode = connection.getResponseCode();

        if (responseCode == HTTP_OK) {
            return getHttpResponseResult(connection.getInputStream(), SUCCEEDED, path);
        }

        if (responseCode == HTTP_INTERNAL_ERROR) {
            return getHttpResponseResult(connection.getErrorStream(), FAILED, path);
        }

        return HttpResponseResult.RESPONSE_EXCEPTION_RESULT;
    }

    private HttpResponseResult getHttpResponseResult(InputStream inputStream, ResponseResultType succeeded, String path) throws IOException {
        String response = CharStreams.toString(new InputStreamReader(inputStream, DEFAULT_CHARSET));
        return new HttpResponseResult(succeeded, response);
    }

    private void send(String request, HttpURLConnection connection) throws IOException {
        byte[] bytes = request.getBytes(DEFAULT_CHARSET);
        connection.setFixedLengthStreamingMode(bytes.length);
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    private HttpURLConnection initConnection(String path) throws IOException {
        URL url = new URL(DEFAULT_PROTOCOL, host, port, path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        setRequestProperties(connection);

        connection.setDoOutput(true);
        return connection;
    }

    private void setRequestProperties(HttpURLConnection connection) {
        connection.setRequestProperty(HEADER_CONTENT_TYPE, VALUE_APPLICATION_JSON);
//        connection.setRequestProperty(HEADER_X_SFUSER, accountID);
//        connection.setRequestProperty(HEADER_X_CREDENTIAL, accountPassword);
        connection.setConnectTimeout(CONNECT_TIMEOUT_MILLIS);
        connection.setReadTimeout(READ_TIMEOUT_MILLIS);

        if (Build.VERSION.SDK_INT > 13) {
            //HACK: fixed http://stackoverflow.com/questions/15411213/android-httpsurlconnection-eofexception
            connection.setRequestProperty("Connection", "close");
        }

        for (String key : propertiesMap.keySet()) {
            connection.setRequestProperty(key, propertiesMap.get(key));
        }
    }

}
