package sf.com.itsp.orderDetail;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Vehicle;

import static sf.com.itsp.orderDetail.OrderDetailHolder.vehicleNumber;
import static sf.com.itsp.orderDetail.OrderDetailHolder.vehiclePhoto;

public class VehicleViewAdapter extends RecyclerViewAdapter<Vehicle> {
    public VehicleViewAdapter(Context context) {
        super(context);
    }

    @Override
    public void buildView(View view) {
        vehiclePhoto = (ImageView) view.findViewById(R.id.item_image);
        vehicleNumber = (TextView) view.findViewById(R.id.item_text);
    }

    @Override
    public void updateView(OrderDetailHolder viewHolder, int position) {
        vehiclePhoto.setImageResource(items.get(position).getPhoto());
        vehicleNumber.setText(items.get(position).getNumber());
    }
}
