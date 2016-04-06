package sf.com.itsp;

import android.app.Activity;
import android.os.AsyncTask;
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
    private CarrierOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListView();
        requestOrder();
    }

    private void requestOrder() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestOrder();
            }

            @Override
            protected void onPostExecute(String orderAsJson) {
                orderList = JsonConverter.jsonFromObjectList(orderAsJson, TypeToken.get(Order[].class));
                adapter.setOrderList(orderList);
            }
        };

        asyncTask.execute();
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.order_list);
        adapter = new CarrierOrderAdapter(getApplicationContext());
        listView.setAdapter(adapter);
    }
}