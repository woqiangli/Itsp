package sf.com.itsp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.orderDetail.VehicleViewAdapter;

public class OrderDetailActivity extends Activity {
    private RecyclerView driverView;
    private RecyclerView vehicleView;
    private DriverViewAdapter driverAdapter;
    private VehicleViewAdapter vehicleAdapter;
    private List<Driver> driverList = new ArrayList<Driver>();
    private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        initDatas();

        driverView = (RecyclerView) findViewById(R.id.driver_view);
        vehicleView = (RecyclerView) findViewById(R.id.vehicle_view);

        LinearLayoutManager driverLinearLayoutManager = new LinearLayoutManager(this);
        driverLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager vehicleLinearLayoutManager = new LinearLayoutManager(this);
        vehicleLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        driverView.setLayoutManager(driverLinearLayoutManager);
        vehicleView.setLayoutManager(vehicleLinearLayoutManager);

        driverAdapter = new DriverViewAdapter(getApplicationContext(), driverList);
        vehicleAdapter = new VehicleViewAdapter(getApplicationContext(), vehicleList);
        driverView.setAdapter(driverAdapter);
        vehicleView.setAdapter(vehicleAdapter);
    }

    private void initDatas() {
        driverList.add(new Driver(R.drawable.enter, "Dr.1"));
        driverList.add(new Driver(R.drawable.enter, "Dr.2"));
        driverList.add(new Driver(R.drawable.enter, "Dr.3"));
        driverList.add(new Driver(R.drawable.enter, "Dr.4"));
        driverList.add(new Driver(R.drawable.enter, "Dr.5"));
        driverList.add(new Driver(R.drawable.enter, "Dr.6"));
        driverList.add(new Driver(R.drawable.enter, "Dr.7"));
        driverList.add(new Driver(R.drawable.enter, "Dr.8"));
        driverList.add(new Driver(R.drawable.enter, "Dr.9"));
        driverList.add(new Driver(R.drawable.enter, "Dr.11"));

        vehicleList.add(new Vehicle(R.drawable.car, "Vc.1"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.2"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.3"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.4"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.5"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.6"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.7"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.8"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.9"));
        vehicleList.add(new Vehicle(R.drawable.car, "Vc.11"));

    }
}