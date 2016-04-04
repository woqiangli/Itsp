package sf.com.itsp.shadows;

import org.robolectric.annotation.Implements;
import org.robolectric.annotation.RealObject;

import sf.com.itsp.utils.ConnectionProxy;

@Implements(sf.com.itsp.utils.ConnectionProxy.class)
public class ShadowConnectionProxy {

    public static String orders;

    @RealObject
    private ConnectionProxy connectionProxy;

    public String requestOrder() {
        return orders;
    }
}