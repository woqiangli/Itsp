package sf.com.itsp.vehicle;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import sf.com.itsp.adapter.ItspBaseAdapter;

public class VehicleAdapter extends ItspBaseAdapter<VehicleItemView, VehicleModel> {
    private int lastSelection = BaseAdapter.NO_SELECTION;

    public VehicleAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(VehicleItemView view, int position) {
        view.updateView(getItem(position));
    }

    @Override
    protected VehicleItemView buildView(ViewGroup parent) {
        return new VehicleItemView(context);
    }

    public void select(int position) {
        items.get(position).setIsSelected(true);
        if (lastSelection != NO_SELECTION && lastSelection != position) {
            items.get(lastSelection).setIsSelected(false);
        }

        lastSelection = position;
        notifyDataSetChanged();
    }
}
