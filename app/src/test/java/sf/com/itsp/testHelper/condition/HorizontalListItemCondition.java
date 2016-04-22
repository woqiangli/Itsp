package sf.com.itsp.testHelper.condition;

import android.view.ViewGroup;
import android.widget.ListAdapter;

public class HorizontalListItemCondition extends ViewContainsItemsCondition {
    public HorizontalListItemCondition(int numberOfItems) {
        super(numberOfItems);
    }

    @Override
    protected int getCount(ViewGroup listView) {
        HorizontalListView view = (HorizontalListView) listView;
        ListAdapter adapter = view.getAdapter();
        return adapter == null ? 0 : adapter.getCount();
    }

    public static HorizontalListItemCondition numberOfItems(int numberOfItems) {
        return new HorizontalListItemCondition(numberOfItems);
    }
}
