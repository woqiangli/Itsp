package sf.com.itsp.vehicle;

import sf.com.itsp.domain.Vehicle;

public class VehicleModel {
    private Vehicle vehicle;

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    private boolean isSelected;

    public static VehicleModel fromVehicle(Vehicle vehicle) {
        return new VehicleModel(vehicle);
    }

    private VehicleModel(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
