package sf.com.itsp.order;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Order;

import static java.lang.String.format;
import static java.lang.String.valueOf;
import static sf.com.itsp.utils.Clock.formatDateAsYyyyMmDd;

public class OrderItemView extends LinearLayout {
    public static final String CHAR_SPILTER_FORMATTER = "%s -- %s";
    private TextView weightValueTextView;
    private TextView lineTextView;
    private TextView vehicleTypeTextView;
    private TextView vehicleAgeTextView;
    private TextView taskDurationTextView;

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
        taskDurationTextView = (TextView) findViewById(R.id.task_duration);
    }

    public void setModel(Order order) {
        weightValueTextView.setText(valueOf(order.getWeight()));
        lineTextView.setText(format(CHAR_SPILTER_FORMATTER, order.getOriginal(), order.getTarget()));
        vehicleTypeTextView.setText(order.getVehicleType());
        vehicleAgeTextView.setText(valueOf(order.getVehicleAge()));

        taskDurationTextView.setText(format(CHAR_SPILTER_FORMATTER,
                formatDateAsYyyyMmDd(order.getStartDate()),
                formatDateAsYyyyMmDd(order.getEndDate())));
    }
}