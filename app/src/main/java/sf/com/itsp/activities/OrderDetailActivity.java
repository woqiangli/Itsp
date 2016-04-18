package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.vehicle.VehicleAdapter;
import sf.com.itsp.vehicle.VehicleModel;

import static com.google.common.collect.Lists.newArrayList;

public class OrderDetailActivity extends Activity {

    private HorizontalListView vehicleList;
    private VehicleAdapter vehicleAdapter;

    private DriverViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
        initUi();
        refreshUi();
    }

    private void initUi() {
        initVehicleList();
        initDriverListView();
    }

    private void requestVehicleList() {
        new AsyncTask<Void, Void, List<Vehicle>>() {
            @Override
            protected List<Vehicle> doInBackground(Void... voids) {
                return ConnectionProxy.getInstance().requestVehicleList(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Vehicle> vehicles) {
                vehicleAdapter.loadData(newArrayList(Iterables.transform(vehicles, new Function<Vehicle, VehicleModel>() {
                    @Override
                    public VehicleModel apply(Vehicle vehicle) {
                        return VehicleModel.fromVehicle(vehicle);
                    }
                })));
            }
        }.execute();
    }

    private void requestDriver() {
        new AsyncTask<Void, Void, List<Driver>>() {
            @Override
            protected List<Driver> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestDriver(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Driver> drivers) {
                refreshListView(drivers);
            }
        }.execute();
    }

    private void refreshListView(List<Driver> drivers) {
        adapter.setItems(drivers);
    }

    private void refreshUi() {
        requestVehicleList();
        requestDriver();
    }

    private void initVehicleList() {
        vehicleAdapter = new VehicleAdapter(this, R.layout.vehicle_item);
        vehicleList = (HorizontalListView) findViewById(R.id.vehicle_list);
        vehicleList.setAdapter(vehicleAdapter);
    }

    private void initDriverListView() {
        adapter = new DriverViewAdapter(getApplicationContext());
        sf.com.itsp.orderDetail.HorizontalListView listView = (sf.com.itsp.orderDetail.HorizontalListView) findViewById(R.id.driver_image_list);
        listView.setAdapter(adapter);
    }
}