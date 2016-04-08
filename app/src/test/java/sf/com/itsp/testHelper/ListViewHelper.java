package sf.com.itsp.testHelper;

import android.widget.ListView;

public class ListViewHelper {

    public static void clickPositionInListView(ListView listView, int posotion) {
        listView.performItemClick(null, posotion, 0);
    }
}
