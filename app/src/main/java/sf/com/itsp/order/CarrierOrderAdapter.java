package sf.com.itsp.order;

import android.content.Context;
import android.view.ViewGroup;

import sf.com.itsp.adapter.ItspBaseAdapter;
import sf.com.itsp.domain.Order;

public class CarrierOrderAdapter extends ItspBaseAdapter<OrderItemView, Order> {
    public CarrierOrderAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(OrderItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected OrderItemView buildView(ViewGroup parent) {
        return new OrderItemView(context);
    }
}