package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.gson.reflect.TypeToken;
import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.Iterator;
import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.utils.JsonConverter;
import sf.com.itsp.vehicle.VehicleAdapter;
import sf.com.itsp.vehicle.VehicleModel;

public class OrderDetailActivity extends Activity {

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
            protected void onPostExecute(List<Vehicle> vehicleList) {
                Iterable<VehicleModel> transform = Iterables.transform(vehicleList, new Function<Vehicle, VehicleModel>() {
                    @Override
                    public VehicleModel apply(Vehicle vehicle) {
                        return VehicleModel.fromVehicle(vehicle);
                    }
                });
                vehicleAdapter.loadData(Lists.newArrayList(transform));
            }
        }.execute();
    }

    private void requestDriver() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                //return ConnectionProxy.getInstance().requestDriver(getApplicationContext());
                return "";
            }

            @Override
            protected void onPostExecute(String driverAsJson) {
                refreshListView(driverAsJson);
            }
        };
        asyncTask.execute();
    }

    private void refreshListView(String driverAsJson) {
        List<Driver> driverList = JsonConverter.jsonFromObjectList(driverAsJson, TypeToken.get(Driver[].class));
        adapter.setDriverList(driverList);
    }

    private void refreshUi() {
        requestVehicleList();
        requestDriver();
    }

    private void initVehicleList() {
        vehicleAdapter = new VehicleAdapter(this, R.layout.vehicle_item);
        HorizontalListView vehicleList = (HorizontalListView) findViewById(R.id.vehicle_list);
        vehicleList.setAdapter(vehicleAdapter);
    }

    private void initDriverListView() {
        adapter = new DriverViewAdapter(getApplicationContext());
        sf.com.itsp.orderDetail.HorizontalListView listView = (sf.com.itsp.orderDetail.HorizontalListView) findViewById(R.id.driver_image_list);
        listView.setAdapter(adapter);


    }
}