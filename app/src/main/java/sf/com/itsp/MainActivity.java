package sf.com.itsp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import sf.com.itsp.tasks.TaskAdapter;
import sf.com.itsp.utils.ConnectionProxy;

public class MainActivity extends Activity {
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    public void initData() {
        new AsyncTask<Void, Void, List>() {
            @Override
            protected List doInBackground(Void... params) {
                return ConnectionProxy.getInstance().requestTask(getApplicationContext());
            }

            @Override
            protected void onPostExecute(List tasks) {
                taskAdapter.setItems(tasks);
            }
        }.execute();
    }

    public void initView() {
        taskAdapter = new TaskAdapter(getApplicationContext());
        ListView listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(taskAdapter);
    }
}