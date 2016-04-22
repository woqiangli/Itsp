package sf.com.itsp.orderDetail;

import android.content.Context;

import java.util.List;

import sf.com.itsp.domain.Driver;

public class DriverViewAdapter extends RecyclerViewAdapter {
    private List<Driver> driverList;

    public DriverViewAdapter(Context context, List<Driver> driverList) {
        super(context, driverList);
        this.driverList = driverList;
    }

    @Override
    public void updateView(ViewHolder viewHolder, int i) {
        viewHolder.itemPhoto.setImageResource(driverList.get(i).getDriverImageId());
        viewHolder.itemName.setText(driverList.get(i).getDriverName());
    }
}
