package sf.com.itsp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import sf.com.itsp.domain.Order;
import sf.com.itsp.order.CarrierOrderAdapter;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.utils.JsonConverter;

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
        String json = ConnectionProxy.getInstance().requestOrder();
        orderList = JsonConverter.jsonToObject(json, new TypeToken<List<Order>>() {});
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.order_list);
        CarrierOrderAdapter adapter = new CarrierOrderAdapter(getApplicationContext());
        Order order = new Order();
        order.setVehicleType("货柜车");
        orderList.add(order);
        adapter.setOrderList(orderList);
        listView.setAdapter(adapter);
    }
}