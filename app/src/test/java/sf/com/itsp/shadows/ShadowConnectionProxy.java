package sf.com.itsp.shadows;

import android.content.Context;

import org.robolectric.annotation.Implements;

@Implements(sf.com.itsp.utils.ConnectionProxy.class)
public class ShadowConnectionProxy {

    public static String orders;

    public String requestOrder(Context context) {
        return orders;
    }
}