package sf.com.itsp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;
import sf.com.itsp.order.CarrierOrderAdapter;
import sf.com.itsp.utils.ConnectionProxy;

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
        AsyncTask<Void, Void, List> asyncTask = new AsyncTask<Void, Void, List>() {
            @Override
            protected List doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestOrder(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List orders) {
                refreshListView(orders);
            }
        };

        asyncTask.execute();
    }

    private void refreshListView(List orders) {
        adapter.setItems(orders);
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.order_list);
        adapter = new CarrierOrderAdapter(getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = adapter.getItem(position);
                gotoOrderDetailView(order);
            }
        });
    }

    private void gotoOrderDetailView(Order order) {
        Intent intent = new Intent();
        intent.putExtra("order", order);
        intent.setClass(getApplicationContext(), OrderDetailActivity.class);

        startActivity(intent);
    }
}