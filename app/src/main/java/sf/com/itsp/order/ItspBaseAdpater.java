package sf.com.itsp.order;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ItspBaseAdpater<TView extends View> extends BaseAdapter {

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TView view;

        if (convertView == null) {
            view = buildView(parent);
        } else {
            view = (TView) convertView;
        }

        updateView(view, position);

        return view;
    }

    protected abstract void updateView(TView view, int position);

    protected abstract TView buildView(ViewGroup parent);
}