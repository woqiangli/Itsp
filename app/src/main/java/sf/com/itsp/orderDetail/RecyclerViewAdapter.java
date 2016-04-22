package sf.com.itsp.orderDetail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sf.com.itsp.R;

public abstract class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LayoutInflater itemInflater;
    private List items;

    public RecyclerViewAdapter(Context context, List itemList) {
        itemInflater = LayoutInflater.from(context);
        this.items = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemPhoto;
        public TextView itemName;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = itemInflater.inflate(R.layout.order_detail_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        viewHolder.itemPhoto = (ImageView) view.findViewById(R.id.item_image);
        viewHolder.itemName = (TextView) view.findViewById(R.id.item_text);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        updateView(viewHolder, i);
    }

    public abstract void updateView(ViewHolder viewHolder, int i);
}
