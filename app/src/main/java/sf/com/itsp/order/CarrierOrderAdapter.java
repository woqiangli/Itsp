package sf.com.itsp.order;

import android.content.Context;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import sf.com.itsp.domain.Order;

import static java.util.Arrays.asList;

public class CarrierOrderAdapter extends ItspBaseAdpater<OrderItemView> {
    private Context context;
    private List<Order> orderList = Collections.emptyList();

    public CarrierOrderAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected void updateView(OrderItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected OrderItemView buildView(ViewGroup parent) {
        return new OrderItemView(context);
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Order getItem(int position) {
        return orderList.get(position);
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
        notifyDataSetChanged();
    }
}