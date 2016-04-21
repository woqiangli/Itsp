package sf.com.itsp.testHelper.condition;

import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewContainsItemCondition extends ViewContainsItemsCondition {
    public ListViewContainsItemCondition(int numberOfItems) {
        super(numberOfItems);
    }

    @Override
    protected int getCount(ViewGroup listView) {
        ListAdapter adapter = ((ListView)listView).getAdapter();
        return adapter == null ? 0 : adapter.getCount();
    }

    public static ListViewContainsItemCondition numberOfItems(int numberOfItems) {
        return new ListViewContainsItemCondition(numberOfItems);
    }
}
