package sf.com.itsp.tasks;

import android.content.Context;
import android.view.ViewGroup;

import sf.com.itsp.adapter.ItspBaseAdapter;
import sf.com.itsp.domain.Task;

public class TaskAdapter extends ItspBaseAdapter<TaskItemView, Task>{

    public TaskAdapter(Context context) {
        super(context);
    }

    @Override
    protected void updateView(TaskItemView view, int position) {
        view.setModel(getItem(position));
    }

    @Override
    protected TaskItemView buildView(ViewGroup parent) {
        return new TaskItemView(context);
    }
}
