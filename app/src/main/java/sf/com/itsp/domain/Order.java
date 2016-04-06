package sf.com.itsp.domain;

public class Order {
    private String original;
    private String target;
    private String vehicleType;

    private double weight;
    private int vehicleAge;

    public int getVehicleAge() {
        return vehicleAge;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public String getVehicleType() { return vehicleType; }
}