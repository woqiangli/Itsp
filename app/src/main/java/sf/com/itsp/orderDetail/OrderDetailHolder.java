package sf.com.itsp.orderDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderDetailHolder extends RecyclerView.ViewHolder {
    public static ImageView driverPhoto;
    public static TextView driverName;

    public static ImageView vehiclePhoto;
    public static TextView vehicleNumber;

    public OrderDetailHolder(View itemView) {
        super(itemView);
    }
}
