package sf.com.itsp.orderDetail;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class DriverViewPagerAdapter extends PagerAdapter {
    private Context pagerAdapter;
    private List<DriverImageView> driverList;

    public DriverViewPagerAdapter(Context context, List<DriverImageView> list) {
        pagerAdapter = context;
        driverList = list;
    }

    @Override
    public int getCount() {
        return driverList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(driverList.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(driverList.get(position), 0);
        return driverList.get(position);
    }
}
