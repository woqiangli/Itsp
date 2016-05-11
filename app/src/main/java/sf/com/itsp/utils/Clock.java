package sf.com.itsp.utils;

import org.joda.time.DateTime;

import java.util.Date;

public class Clock {

    public static String formatDateAsYyyyMmDd(Date startDate) {
        return new DateTime(startDate).toString("yyyy-MM-dd");
    }
}
