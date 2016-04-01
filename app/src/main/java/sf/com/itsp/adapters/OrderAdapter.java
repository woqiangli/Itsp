package sf.com.itsp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.model.Order;

public class OrderAdapter extends ArrayAdapter<Order> {
    public OrderAdapter(Context context, int textViewResourceId, List<Order> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Order order = getItem(position);

        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.order_item, null);

        TextView weightValue = (TextView) inflate.findViewById(R.id.weight_value);
        TextView lineView = (TextView) inflate.findViewById(R.id.line_view);

        weightValue.setText(String.valueOf(order.getWeight()));
        lineView.setText(String.format("%s -- %s", order.getOriginal(), order.getTarget()));

        return inflate;
    }
}
