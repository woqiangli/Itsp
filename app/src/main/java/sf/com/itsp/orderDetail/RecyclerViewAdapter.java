package sf.com.itsp.orderDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import sf.com.itsp.R;

public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter<OrderDetailHolder> {

    protected Context context;
    protected List<T> items = Collections.emptyList();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public OrderDetailHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_detail_item, viewGroup, false);

        buildView(view);

        OrderDetailHolder viewHolder = new OrderDetailHolder(view);

        updateView(viewHolder, i);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OrderDetailHolder viewHolder, final int i) {
        updateView(viewHolder, i);
    }

    public abstract void buildView(View view);

    public abstract void updateView(OrderDetailHolder orderDetailHolder, int position);

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
