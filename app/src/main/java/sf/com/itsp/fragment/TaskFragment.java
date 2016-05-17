package sf.com.itsp.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import sf.com.itsp.R;
import sf.com.itsp.domain.Task;
import sf.com.itsp.domain.Vehicle;
import sf.com.itsp.tasks.TaskAdapter;
import sf.com.itsp.utils.ConnectionProxy;

public class TaskFragment extends Fragment {
    private TextView vehicleNumber;

    private TaskAdapter taskAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.task_fragment, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initView(View view) {
        initMissionInfoView(view);

        initTaskListView(view);
    }

    private void initTaskListView(View view) {
        taskAdapter = new TaskAdapter(getActivity().getApplicationContext());
        ListView listView = (ListView) view.findViewById(R.id.task_list);
        listView.setAdapter(taskAdapter);
    }

    private void initMissionInfoView(View view) {
        vehicleNumber = (TextView) view.findViewById(R.id.vehicle_number);
    }


    public void initData() {
        initMissionInfo();

        initTaskList();
    }

    private void initTaskList() {
        new AsyncTask<Void, Void, List<Task>>() {
            @Override
            protected List<Task> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestTask(getActivity().getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Task> tasks) {
                taskAdapter.setItems(tasks);
            }
        }.execute();
    }

    private void initMissionInfo() {
        new AsyncTask<Void, Void, List<Vehicle>>() {
            @Override
            protected List<Vehicle> doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestVehicle(getActivity().getApplicationContext());
            }

            @Override
            protected void onPostExecute(List<Vehicle> vehicles) {
                vehicleNumber.setText(vehicles.get(0).getVehicleNumber());
            }
        }.execute();
    }
}
