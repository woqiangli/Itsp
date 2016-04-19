package sf.com.itsp.vehicle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import sf.com.itsp.R;

public class VehicleItemView extends RelativeLayout {

    private ImageView photo;
    private TextView name;
    private ImageView selectedIcon;

    public VehicleItemView(Context context) {
        super(context);
        initUi();
    }

    public VehicleItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public VehicleItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.vehicle_item, this, true);
        photo = (ImageView) findViewById(R.id.vehicle_item_photo);
        name = (TextView) findViewById(R.id.vehicle_item_name);
        selectedIcon = (ImageView) findViewById(R.id.selected_icon);
    }

    public void updateView(VehicleModel vehicleModel) {
        photo.setImageResource(vehicleModel.getVehicle().getPhoto());
        name.setText(vehicleModel.getVehicle().getNumber());
        selectedIcon.setVisibility(vehicleModel.isSelected() ? ImageView.VISIBLE : ImageView.INVISIBLE);

    }
}
