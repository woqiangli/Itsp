package sf.com.itsp.orderDetail;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
import sf.com.itsp.R;

public class DriverViewPager extends FrameLayout{
    private List<DriverImageView> driverList;
    private Context driverViewContext;
    private ViewPager driverViewPager;
    private ViewGroup driverViewGroup;
    private List<Integer> driverImageIds;

    public DriverViewPager(Context context, List<DriverImageView> driverList) {
        super(context);
        creatView(context, driverList);
    }

    public void creatView(Context context, List<DriverImageView> imageList){
        driverViewContext = context;
        LayoutInflater.from(context).inflate(R.layout.driver_view_pager, this);
        driverViewPager = (ViewPager)findViewById(R.id.viewpager);
        driverViewGroup = (ViewGroup)findViewById(R.id.driverViewPager);
        driverList = imageList;
        driverImageIds = new ArrayList<Integer>();

        build();
    }

    public void build(){
        driverViewPager.setAdapter(new DriverViewPagerAdapter(driverViewContext, driverList));

        driverViewPager.setCurrentItem(0);

        driverViewPager.setOffscreenPageLimit(4);
    }

    public void setmImageViews(List<DriverImageView> imageViews) {
        driverList = imageViews;
        driverViewPager.notify();
        driverViewPager.setCurrentItem(0);
    }
}
