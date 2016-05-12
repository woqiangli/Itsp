package sf.com.itsp.utils;

import android.content.Context;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import sf.com.itsp.connectivity.HttpClient;
import sf.com.itsp.domain.ServerAddress;
import sf.com.itsp.domain.Task;

import static sf.com.itsp.utils.ConnectionProxy.RequestPath.Tasks;

public class ConnectionProxy {
    private static ConnectionProxy instance;

    public static ConnectionProxy getInstance() {
        if (instance == null) {
            instance = new ConnectionProxy();
        }
        return instance;
    }

    private ConnectionProxy() {

    }

    public List<Task> requestTask(Context context) {
        List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("深圳市中转场","装车"));
        taskList.add(new Task("长沙中转场","卸车"));
//        return (List<Task>) Tasks.request(context);
        return taskList;
    }


    public enum RequestPath {
        Tasks("tasks", Task[].class);

        private final String path;
        private final TypeToken typeToken;

        RequestPath(String path, Class clazz) {
            this.path = path;
            this.typeToken = TypeToken.get(clazz);
        }

        public List<?> request(Context context) {
            ServerAddress serverAddress = PropertiesProvider.getInstance(context).getServerAddress();
            String request = new HttpClient(serverAddress.host, serverAddress.port).request(path);

            return convert(request);
        }

        public List<?> convert(String dataAsJson) {
            return JsonConverter.jsonFromObjectList(dataAsJson, typeToken);
        }
    }
}