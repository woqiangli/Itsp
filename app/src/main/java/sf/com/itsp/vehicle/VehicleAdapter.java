package sf.com.itsp.vehicle;

import android.content.Context;
import android.view.ViewGroup;

import sf.com.itsp.adapter.ItspBaseAdapter;

public class VehicleAdapter extends ItspBaseAdapter<VehicleItemView, VehicleModel> {


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
}
