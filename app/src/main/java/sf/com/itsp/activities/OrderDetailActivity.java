package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.reflect.TypeToken;
import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.utils.JsonConverter;
import sf.com.itsp.vehicle.VehicleAdapter;
import sf.com.itsp.vehicle.VehicleModel;

import static sf.com.itsp.utils.Constant.INTENT_KEY_ORDER;

public class OrderDetailActivity extends Activity {

    private TextView originView;
    private TextView targetView;
    private HorizontalListView vehicleList;
    private VehicleAdapter vehicleAdapter;
    private List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);
        requestVehicleList();
        refreshUi();
    }

    private void requestVehicleList() {
        for(int i=0; i <20;i++){
            VehicleModel vehicleModel = new VehicleModel();
            vehicleModel.setName("user"+i);
            vehicleModel.setPhoto(R.drawable.car);
            vehicleModel.setIsSelected(true);
            vehicleModelList.add(vehicleModel);
        }
    }


    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);
        originView = (TextView) findViewById(R.id.origin_view);
        targetView = (TextView) findViewById(R.id.target_view);
        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());

        initVehicleList();
    }

    private void initVehicleList() {
        vehicleAdapter = new VehicleAdapter(this, R.layout.vehicle_item,vehicleModelList);
        vehicleList = (HorizontalListView) findViewById(R.id.vehicle_list);
        vehicleList.setAdapter(vehicleAdapter);
    }

}