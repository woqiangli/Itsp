package sf.com.itsp.utils;

import com.google.gson.reflect.TypeToken;

import sf.com.itsp.domain.Task;

import static sf.com.itsp.shadows.ShadowConnectionProxy.fakeTasks;

public class TaskProvider {
    private static final String TASKS = "[" +
            "{'address': '深圳市中转场','operation':'装车'}," +
            "{'address': '长沙中转场','operation':'卸车'}]";

    public static void mockTaskResponse() {
        fakeTasks(JsonConverter.<Task>jsonFromObjectList(TASKS, TypeToken.get(Task[].class)));
    }
}
