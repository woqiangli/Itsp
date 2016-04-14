package sf.com.itsp.vehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Vehicle;

public class VehicleAdapter extends ArrayAdapter<VehicleModel> {
    private int itemLayout;

    public VehicleAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        itemLayout = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vehicleItem = inflater.inflate(itemLayout, parent, false);
        ImageView photo = (ImageView) vehicleItem.findViewById(R.id.vehicle_item_photo);
        TextView name = (TextView) vehicleItem.findViewById(R.id.vehicle_item_name);
        ImageView selectedIcon = (ImageView) vehicleItem.findViewById(R.id.selected_icon);
        VehicleModel vehicleModel = getItem(position);
        photo.setImageResource(vehicleModel.getVehicle().getPhoto());
        name.setText(vehicleModel.getVehicle().getNumber());
        selectedIcon.setVisibility(vehicleModel.isSelected() ? ImageView.VISIBLE : ImageView.INVISIBLE);
        return vehicleItem;
    }

    public void loadData(List<VehicleModel> vehicleModelList){
        this.addAll(vehicleModelList);
    }

}
