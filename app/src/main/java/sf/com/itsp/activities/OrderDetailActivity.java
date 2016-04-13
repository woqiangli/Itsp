package sf.com.itsp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.orderDetail.HorizontalListView;
import static sf.com.itsp.utils.Constant.INTENT_KEY_ORDER;

public class OrderDetailActivity extends Activity {

    private TextView originView;
    private TextView targetView;

    private HorizontalListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

//        originView = (TextView) findViewById(R.id.origin_view);
//        targetView = (TextView) findViewById(R.id.target_view);
//
//        refreshUi();

        initializeViews();

    }

    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);

        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());
    }

    private void initializeViews() {
        listview = (HorizontalListView) findViewById(R.id.driver_image_list);

        listview.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.driver_view_item, null);
            return view;
        }
    }

}