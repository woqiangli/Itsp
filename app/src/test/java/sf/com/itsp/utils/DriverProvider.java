package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Driver;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeDrivers;

public class DriverProvider {
    private static final String DRIVERS = "[" +
            "{'driverPhoto': 1, 'driverName': 'A'}," +
            "{'driverPhoto': 2, 'driverName': 'B'}," +
            "{'driverPhoto': 3, 'driverName': 'C'}]";

    public static void mockDriverResponse() {
        fakeDrivers(JsonConverter.<Driver>jsonFromObjectList(DRIVERS, TypeToken.get(Driver[].class)));
    }
}
