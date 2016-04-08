package sf.com.itsp.domain;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
    private String original;
    private String target;
    private String vehicleType;

    private double weight;
    private int vehicleAge;

    private Date startDate;
    private Date endDate;

    private double publishTime;

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getVehicleAge() {
        return vehicleAge;
    }

    public String getOriginal() {
        return original;
    }

    public String getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public double getPublishTime() {
        return publishTime;
    }
}