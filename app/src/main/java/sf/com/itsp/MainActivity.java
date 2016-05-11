package sf.com.itsp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import sf.com.itsp.domain.Task;
import sf.com.itsp.tasks.TaskAdapter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Task> tasks = new ArrayList<Task>();
        tasks.add(new Task("深圳市中转场"));
        tasks.add(new Task("长沙中转场"));
        TaskAdapter adapter = new TaskAdapter(MainActivity.this,R.layout.task_item,tasks);
        ListView listView = (ListView) findViewById(R.id.task_list);
        listView.setAdapter(adapter);
    }

}