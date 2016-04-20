package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Driver;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeDrivers;

public class DriverProvider {
    public static final String DRIVERS = "[{'driverImageId': 1},{'driverImageId': 2},{'driverImageId': 3}]";

    public static void mockEmptyDriverResponse() {
        ShadowConnectionProxy.clearDrivers();
    }

    public static void mockDriverResponse() {
        fakeDrivers(JsonConverter.<Driver>jsonFromObjectList(DRIVERS, TypeToken.get(Driver[].class)));
    }
}
