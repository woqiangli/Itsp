package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.orderDetail.VehicleViewAdapter;
import sf.com.itsp.utils.ConnectionProxy;

public class OrderDetailActivity extends Activity {
    private DriverViewAdapter driverAdapter;
    private VehicleViewAdapter vehicleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        initView();
        requestData();

    }

    private void requestData() {
        requestDriver();

        requestVehicle();
    }

    private void requestDriver() {
        new AsyncTask<Void, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestDriver(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                driverAdapter.setItems(drivers);
            }
        }.execute();
    }

    private void requestVehicle() {
        new AsyncTask<Void, Void, List<Vehicle>>() {
            @Override
            protected List<Vehicle> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestVehicle(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Vehicle> vehicles) {
                vehicleAdapter.setItems(vehicles);
            }
        }.execute();
    }

    private void initView() {
        initDriverView();
        initVehicleView();
    }

    private void initDriverView() {
        RecyclerView driverView = (RecyclerView) findViewById(R.id.driver_view);

        LinearLayoutManager driverLinearLayoutManager = new LinearLayoutManager(this);
        driverLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        driverView.setLayoutManager(driverLinearLayoutManager);

        driverAdapter = new DriverViewAdapter(getApplicationContext());

        driverView.setAdapter(driverAdapter);
    }

    private void initVehicleView() {
        RecyclerView vehicleView = (RecyclerView) findViewById(R.id.vehicle_view);

        LinearLayoutManager vehicleLinearLayoutManager = new LinearLayoutManager(this);
        vehicleLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        vehicleView.setLayoutManager(vehicleLinearLayoutManager);

        vehicleAdapter = new VehicleViewAdapter(getApplicationContext());

        vehicleView.setAdapter(vehicleAdapter);
    }
}