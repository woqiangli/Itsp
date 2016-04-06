package sf.com.itsp.order;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;

public class OrderItemView extends LinearLayout {
    private TextView weightValueTextView;
    private TextView lineTextView;
    private TextView vehicleTypeTextView;
    private TextView vehicleAgeTextView;

    public OrderItemView(Context context) {
        super(context);
        initUi();
    }

    public OrderItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public OrderItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.order_item, this, true);

        weightValueTextView = (TextView) findViewById(R.id.weight_value);
        lineTextView = (TextView) findViewById(R.id.line_view);
        vehicleTypeTextView = (TextView) findViewById(R.id.vehicle_type_value);
        vehicleAgeTextView = (TextView) findViewById(R.id.vehicle_age_value);
    }

    public void setModel(Order order) {
        weightValueTextView.setText(String.valueOf(order.getWeight()));
        lineTextView.setText(String.format("%s -- %s", order.getOriginal(), order.getTarget()));
        vehicleTypeTextView.setText(order.getVehicleType());
        vehicleAgeTextView.setText(String.valueOf(order.getVehicleAge()));
    }
}
