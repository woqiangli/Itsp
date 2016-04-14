package sf.com.itsp.orderDetail;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Collections;
import java.util.List;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.order.ItspBaseAdpater;

public class DriverViewAdapter extends ItspBaseAdpater<DriverItemView> {
    private Context context;
    private List<Driver> driverList = Collections.emptyList();

    public DriverViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return driverList.size();
    }

    @Override
    public Object getItem(int position) {
        return driverList.get(position);
    }

    @Override
    protected void updateView(DriverItemView view, int position) {
        view.setModel((Driver) getItem(position));
    }

    @Override
    protected DriverItemView buildView(ViewGroup parent) {
        return new DriverItemView(context);
    }

    public void setDriverList(List<Driver> driverList) {
        this.driverList = driverList;
        notifyDataSetChanged();
    }
}
