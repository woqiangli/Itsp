package sf.com.itsp.domain;

public class Vehicle {
    private int vehiclePhoto;
    private String vehicleNumber;

    public Vehicle(int vehiclePhoto, String vehicleNumber) {
        this.vehiclePhoto = vehiclePhoto;
        this.vehicleNumber = vehicleNumber;
    }

    public int getPhoto() {
        return vehiclePhoto;
    }

    public String getNumber() {
        return vehicleNumber;
    }
}
