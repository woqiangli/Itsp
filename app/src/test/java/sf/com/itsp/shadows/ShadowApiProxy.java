package sf.com.itsp.shadows;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

import sf.com.itsp.connectivity.ApiProxy;

@Implements(ApiProxy.class)
public class ShadowApiProxy extends ApiProxy {
    public static String orders;

    private ShadowApiProxy() {
        super();
    }

    @Implementation
    public String requestOrder() {
        return orders;
    }

    public static void reset() {
        orders = "";
    }
}