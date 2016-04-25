package sf.com.itsp.orderDetail;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;

import static sf.com.itsp.orderDetail.OrderDetailHolder.driverName;
import static sf.com.itsp.orderDetail.OrderDetailHolder.driverPhoto;

public class DriverViewAdapter extends RecyclerViewAdapter<Driver> {
    public DriverViewAdapter(Context context) {
        super(context);
    }

    @Override
    public void buildView(View view) {
        driverPhoto = (ImageView) view.findViewById(R.id.item_image);
        driverName = (TextView) view.findViewById(R.id.item_text);
    }

    @Override
    public void updateView(OrderDetailHolder orderDetailHolder, int position) {
        driverPhoto.setImageResource(items.get(position).getDriverImageId());
        driverName.setText(items.get(position).getDriverName());
    }
}
