package sf.com.itsp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meetme.android.horizontallistview.HorizontalListView;

import java.util.ArrayList;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.vehicle.VehicleAdapter;
import sf.com.itsp.vehicle.VehicleModel;

import static sf.com.itsp.utils.Constant.INTENT_KEY_ORDER;

public class OrderDetailActivity extends Activity {

    private TextView originView;
    private TextView targetView;
    private HorizontalListView vehicleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        originView = (TextView) findViewById(R.id.origin_view);
        targetView = (TextView) findViewById(R.id.target_view);
        ArrayList<VehicleModel> vehicleData = getVehicleModelData();
        VehicleAdapter vehicleAdapter = new VehicleAdapter(this, R.layout.vehicle_item, vehicleData);
        vehicleList = (HorizontalListView) findViewById(R.id.vehicle_list);
        vehicleList.setAdapter(vehicleAdapter);
        refreshUi();

    }

    private ArrayList<VehicleModel> getVehicleModelData() {
        ArrayList<VehicleModel> vehicleData = new ArrayList<VehicleModel>();
        for(int i = 0;i<50;i++){
            VehicleModel vehicleModel = new VehicleModel();
            vehicleModel.setName("user"+i);
            vehicleModel.setPhoto(R.drawable.car);
            vehicleModel.setIsSelected(false);
            vehicleData.add(vehicleModel);
        }
        return vehicleData;
    }


    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);

        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());
    }

}