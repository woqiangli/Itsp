package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Vehicle;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeVehicles;

public class VehicleProvider {
    private static final String VEHICLES = "[" +
            "{'vehiclePhoto': 1, 'vehicleNumber': 'Ve.1'}," +
            "{'vehiclePhoto': 2, 'vehicleNumber': 'Ve.2'}," +
            "{'vehiclePhoto': 3, 'vehicleNumber': 'Ve.3'}," +
            "{'vehiclePhoto': 4, 'vehicleNumber': 'Ve.4'}]";

    public static void mockVehicleResponse() {
        fakeVehicles(JsonConverter.<Vehicle>jsonFromObjectList(VEHICLES, TypeToken.get(Vehicle[].class)));
    }
}
