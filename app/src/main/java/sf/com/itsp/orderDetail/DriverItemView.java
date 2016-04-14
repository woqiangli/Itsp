package sf.com.itsp.orderDetail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import sf.com.itsp.R;
import sf.com.itsp.domain.Driver;
import sf.com.itsp.utils.RoundImage;

public class DriverItemView extends LinearLayout {
    private RoundImage driverImageView;

    public DriverItemView(Context context) {
        super(context);
        initUi();
    }

    public DriverItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initUi();
    }

    public DriverItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initUi();
    }

    private void initUi() {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.driver_view_item, this, true);

        driverImageView = (RoundImage) findViewById(R.id.driver_image);
    }

    public void setModel(Driver driver) {
        driverImageView.setImageResource(driver.getDriverImageId());
    }
}