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
    private CarrierOrderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initListView();
        requestOrder();
    }

    private void requestOrder() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestOrder(getApplicationContext());
            }

            @Override
            protected void onPostExecute(String orderAsJson) {
                refreshListView(orderAsJson);
            }
        };

        asyncTask.execute();
    }

    private void refreshListView(String orderAsJson) {
        List<Order> orderList = JsonConverter.jsonFromObjectList(orderAsJson, TypeToken.get(Order[].class));
        adapter.setOrderList(orderList);
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.order_list);
        adapter = new CarrierOrderAdapter(getApplicationContext());
        listView.setAdapter(adapter);
    }
}