
package sf.com.itsp.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.orderDetail.DriverViewAdapter;
import sf.com.itsp.orderDetail.HorizontalListView;
import sf.com.itsp.utils.ConnectionProxy;
import sf.com.itsp.utils.JsonConverter;

public class OrderDetailActivity extends Activity {

    private DriverViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

//        originView = (TextView) findViewById(R.id.origin_view);
//        targetView = (TextView) findViewById(R.id.target_view);
//
//        refreshUi();

        initDriverListView();
        requestDriver();

    }

    private void requestDriver() {
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestDriver(getApplicationContext());
            }

            @Override
            protected void onPostExecute(String driverAsJson) {
                refreshListView(driverAsJson);
            }
        };

        asyncTask.execute();
    }

    private void refreshListView(String driverAsJson) {
        List<Driver> driverList = JsonConverter.jsonFromObjectList(driverAsJson, TypeToken.get(Driver[].class));
        adapter.setDriverList(driverList);
    }

    /**
    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);

        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());
    }
     */

    private void initDriverListView() {
        adapter = new DriverViewAdapter(getApplicationContext());
        HorizontalListView listView = (HorizontalListView) findViewById(R.id.driver_image_list);
        listView.setAdapter(adapter);
    }

}