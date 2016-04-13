package sf.com.itsp.vehicle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sf.com.itsp.R;

public class VehicleAdapter extends ArrayAdapter<VehicleModel> {
    private int itemLayout;

    public VehicleAdapter(Context context, int textViewResourceId, List<VehicleModel> objects) {
        super(context, textViewResourceId, objects);
        itemLayout = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vehicleItem = inflater.inflate(R.layout.vehicle_item, parent, false);
        ImageView photo = (ImageView) vehicleItem.findViewById(R.id.vehicle_item_photo);
        TextView name = (TextView) vehicleItem.findViewById(R.id.vehicle_item_name);
        VehicleModel vehicleModel = getItem(position);
        photo.setImageResource(vehicleModel.getPhoto());
        name.setText(vehicleModel.getName());
        return vehicleItem;
    }

    ;

}
