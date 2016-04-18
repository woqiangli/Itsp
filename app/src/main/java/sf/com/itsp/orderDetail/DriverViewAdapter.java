package sf.com.itsp.orderDetail;

import android.content.Context;
import android.view.ViewGroup;

import sf.com.itsp.adapter.ItspBaseAdapter;
import sf.com.itsp.domain.Driver;

public class DriverViewAdapter extends ItspBaseAdapter<DriverItemView, Driver> {
    public DriverViewAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(DriverItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected DriverItemView buildView(ViewGroup parent) {
        return new DriverItemView(context);
    }
}