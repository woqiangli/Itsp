package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Driver;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeDrivers;

public class DriverProvider {
    private static final String DRIVERS = "[{'driverImageId': 1},{'driverImageId': 2},{'driverImageId': 3}]";

    public static void mockDriverResponse() {
        fakeDrivers(JsonConverter.<Driver>jsonFromObjectList(DRIVERS, TypeToken.get(Driver[].class)));
    }
}
