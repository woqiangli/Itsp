package sf.com.itsp.order;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import sf.com.itsp.R;

public class OrderItemView extends LinearLayout {

    public OrderItemView(Context context) {
        super(context);
    }

    public OrderItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public OrderItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void initUi() {
//        LayoutInflater.from(getContext()).inflate(R.layout.order_item, null);
    }
}
