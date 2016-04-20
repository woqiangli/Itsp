package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.shadows.ShadowConnectionProxy;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeVehicles;

public class VehicleProvider {
    public static final String VEHICLES = "[{'photo': 1\n, 'number': '12345A'},{'photo': 2\n, 'number': '12345B'},{'photo': 3\n, 'number': '12345C'}]";

    public static void mockEmptyVehicleResponse() {
        ShadowConnectionProxy.clearVehicles();
    }

    public static void mockVehicleResponse() {
        fakeVehicles(JsonConverter.<Vehicle>jsonFromObjectList(VEHICLES, TypeToken.get(Vehicle[].class)));
    }
}
