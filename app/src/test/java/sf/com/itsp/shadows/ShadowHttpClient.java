package sf.com.itsp.shadows;


import com.google.gson.Gson;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

import java.util.List;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.model.Order;

import static org.assertj.core.util.Lists.newArrayList;

@Implements(HttpClient.class)
public class ShadowHttpClient {
    public static List<Order> orderAsJson = newArrayList();

    @RealObject
    public HttpClient httpClient;

    @Implementation
    public String requestOrder() {
        return new Gson().toJson(orderAsJson);
    }

    public static void reset() {
        orderAsJson.clear();
    }
}
