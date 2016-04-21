package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.vehicle.VehicleAdapter;
import sf.com.itsp.vehicle.VehicleModel;

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
//        new AsyncTask<Void, Void, List<Vehicle>>() {
//            @Override
//            protected List<Vehicle> doInBackground(Void... voids) {
//                return ConnectionProxy.getInstance().requestVehicleList(getApplicationContext());
//            }
//
//            @Override
//            protected void onPostExecute(List<Vehicle> vehicleList) {
//                Iterable<VehicleModel> transform = Iterables.transform(vehicleList, new Function<Vehicle, VehicleModel>() {
//                    @Override
//                    public VehicleModel apply(Vehicle vehicle) {
//                        return VehicleModel.fromVehicle(vehicle);
//                    }
//                });
//                vehicleAdapter.setItems(Lists.newArrayList(transform));
//            }
//        }.execute();
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
        vehicleAdapter = new VehicleAdapter(getApplicationContext());
        vehicleList = (HorizontalListView) findViewById(R.id.vehicle_list);
        vehicleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                clickVehicleItem(i);
            }
        });
        vehicleList.setAdapter(vehicleAdapter);
    }

    private void clickVehicleItem(int i) {
        VehicleModel item = vehicleAdapter.getItem(i);
        item.setIsSelected(!item.isSelected());
        vehicleAdapter.notifyDataSetChanged();
    }

    private void initDriverListView() {
        adapter = new DriverViewAdapter(getApplicationContext());
        sf.com.itsp.orderDetail.HorizontalListView listView = (sf.com.itsp.orderDetail.HorizontalListView) findViewById(R.id.driver_image_list);
        listView.setAdapter(adapter);
    }
}