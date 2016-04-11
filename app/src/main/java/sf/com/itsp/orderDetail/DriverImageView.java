package sf.com.itsp.orderDetail;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import sf.com.itsp.R;
import sf.com.itsp.utils.RoundImage;

public class DriverImageView extends RelativeLayout {
    private RoundImage roundImage;

    public DriverImageView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.driver_image_view, this);
        roundImage = (RoundImage)findViewById(R.id.driver);
    }

    public void setImage(int id) {
        roundImage.setImageResource(id);
    }
}
