package sf.com.itsp.shadows;

import android.content.Context;

import org.robolectric.annotation.Implements;

import java.util.List;

import sf.com.itsp.domain.Task;
import sf.com.itsp.utils.ConnectionProxy;

import static com.google.common.collect.Lists.newArrayList;

@Implements(ConnectionProxy.class)
public class ShadowConnectionProxy {
    private static List<Task> tasks = newArrayList();

    public static void fakeTasks(List<Task> fakedTasks) {
        tasks = fakedTasks;
    }

    public List<Task> requestTask(Context context) {
        return tasks;
    }

    public static void clearTasks() {
        tasks = newArrayList();
    }
}