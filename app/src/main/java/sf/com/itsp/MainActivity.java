package sf.com.itsp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import sf.com.itsp.order.CarrierOrderAdapter;
import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.Order;

public class MainActivity extends Activity {
    private List<Order> orderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestOrder();
        initListView();
    }

    private void requestOrder() {
        orderList = new HttpClient().requestOrder();
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.order_list);
        CarrierOrderAdapter adapter = new CarrierOrderAdapter(getApplicationContext());
        adapter.setOrderList(orderList);
        listView.setAdapter(adapter);
    }
}