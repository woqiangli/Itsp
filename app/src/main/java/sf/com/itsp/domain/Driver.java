package sf.com.itsp.domain;

public class Driver {
    private int driverPhoto;

    private String driverName;

    public Driver(int driverPhoto, String driverName) {
        this.driverPhoto = driverPhoto;
        this.driverName = driverName;
    }

    public int getDriverImageId() {
        return driverPhoto;
    }

    public String getDriverName() {
        return driverName;
    }
}
