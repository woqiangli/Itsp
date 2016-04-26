package sf.com.itsp.testHelper.condition;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class RecyclerViewContainsItemCondition extends ViewContainsItemsCondition {
    public RecyclerViewContainsItemCondition(int numberOfItems) {
        super(numberOfItems);
    }

    @Override
    protected int getCount(ViewGroup recyclerView) {
        RecyclerView view = (RecyclerView) recyclerView;
        RecyclerView.Adapter adapter = view.getAdapter();

        return adapter == null ? 0 : adapter.getItemCount();
    }

    public static RecyclerViewContainsItemCondition numberOfItems(int numberOfItems) {
        return new RecyclerViewContainsItemCondition(numberOfItems);
    }
}
