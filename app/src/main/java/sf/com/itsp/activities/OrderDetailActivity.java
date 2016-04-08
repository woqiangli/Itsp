package sf.com.itsp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;

import static sf.com.itsp.utils.Constant.INTENT_KEY_ORDER;

public class OrderDetailActivity extends Activity {

    private TextView originView;
    private TextView targetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_detail_activity);

        originView = (TextView) findViewById(R.id.origin_view);
        targetView = (TextView) findViewById(R.id.target_view);

        refreshUi();
    }

    private void refreshUi() {
        Order order = (Order) getIntent().getSerializableExtra(INTENT_KEY_ORDER);

        originView.setText(order.getOriginal());
        targetView.setText(order.getTarget());
    }

}