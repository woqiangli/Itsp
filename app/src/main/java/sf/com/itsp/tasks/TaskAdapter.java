package sf.com.itsp.tasks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Task;

public class TaskAdapter extends ArrayAdapter<Task>{

    private int resourceId;

    public TaskAdapter(Context context, int textViewResourceId,
                       List<Task> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            viewHolder = new ViewHolder();
            viewHolder.addressName = (TextView)view.findViewById(R.id.address_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.addressName.setText(task.getAddress());
        return view;
    }

    class ViewHolder {
        TextView addressName;
    }
}
