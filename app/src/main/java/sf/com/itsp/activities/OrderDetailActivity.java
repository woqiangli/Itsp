package sf.com.itsp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;
import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.orderDetail.DriverImageView;
import sf.com.itsp.orderDetail.DriverViewPager;
import static sf.com.itsp.utils.Constant.INTENT_KEY_ORDER;

public class OrderDetailActivity extends Activity {

    private TextView originView;
    private TextView targetView;

    private int[] driverImageIds;
    private DriverViewPager driverViewPager;
    private ArrayList<DriverImageView> driverImageViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        originView = (TextView) findViewById(R.id.origin_view);
        targetView = (TextView) findViewById(R.id.target_view);

        refreshUi();

        initVehicleImage();
    }

    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);

        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());
    }

    private void initVehicleImage() {
        driverImageIds = new int[]{
                R.drawable.beijing_img,
                R.drawable.shenzhen_img,
                R.drawable.guangzhou_img
        };

        driverViewPager = (DriverViewPager)findViewById(R.id.view_pager_show);

        driverImageViews = new ArrayList<DriverImageView>();
        for (int i = 0 ; i < driverImageIds.length ; i ++){
            DriverImageView imageView = new DriverImageView(this);
            imageView.setImage(driverImageIds[i]);
            driverImageViews.add(imageView);
        }

        driverViewPager.creatView(this, driverImageViews);
    }

}