package sf.com.itsp.vehicle;

import sf.com.itsp.domain.Vehicle;

public class VehicleModel extends Vehicle {
    public Boolean getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    private Boolean isSelected;
}
