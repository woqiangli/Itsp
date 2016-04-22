package sf.com.itsp.orderDetail;

import android.content.Context;

import java.util.List;

import sf.com.itsp.domain.Vehicle;

public class VehicleViewAdapter extends RecyclerViewAdapter {
    private List<Vehicle> vehicleList;

    public VehicleViewAdapter(Context context, List<Vehicle> vehicleList) {
        super(context, vehicleList);
        this.vehicleList = vehicleList;
    }

    @Override
    public void updateView(RecyclerViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemPhoto.setImageResource(vehicleList.get(i).getPhoto());
        viewHolder.itemName.setText(vehicleList.get(i).getNumber());
    }
}
