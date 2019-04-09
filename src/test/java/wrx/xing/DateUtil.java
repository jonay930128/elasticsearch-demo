//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package wrx.xing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public class DateUtil extends DateUtils {
    private static String[] parsePatterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm"};

    public DateUtil() {
    }

    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    public static String getShortDate() {
        return getDate("yyMMdd");
    }

    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String formatDate(Date date, String pattern) {
        String formatDate = null;
        if (date != null && pattern != null && pattern.length() > 0) {
            formatDate = DateFormatUtils.format(date, pattern);
        }

        return formatDate;
    }

    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    public static Date parseDateWithPatterns(String str, String... myPatterns) {
        if (str == null) {
            return null;
        } else {
            try {
                return myPatterns.length > 0 ? parseDate(str, myPatterns) : parseDate(str, parsePatterns);
            } catch (ParseException var3) {
                return null;
            }
        }
    }

    public static Date addDays(Date d, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(5, days);
        Date newD = c.getTime();
        return newD;
    }

    public static Date addMinutes(Date d, int minutes) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(12, minutes);
        Date newD = c.getTime();
        return newD;
    }

    public static long pastDays(Date date) {
        long t = System.currentTimeMillis() - date.getTime();
        return t / 86400000L;
    }

    public static List<String> getDateList(Date beginDate, int days) {
        List<String> dateList = new ArrayList();
        if (null == beginDate) {
            return dateList;
        } else {
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Calendar to = Calendar.getInstance();
                to.setTime(beginDate);
                dateList.add(df.format(to.getTime()));

                for(int i = 0; i < days; ++i) {
                    to.add(5, 1);
                    dateList.add(df.format(to.getTime()));
                }

                return dateList;
            } catch (Exception var6) {
                return dateList;
            }
        }
    }

    public static Date dayOffsets(Date date, int offsets) {
        if (null == date) {
            return null;
        } else {
            int year = Integer.parseInt(DateFormatUtils.format(date, "yyyy"));
            int month = Integer.parseInt(DateFormatUtils.format(date, "MM")) - 1;
            int day = Integer.parseInt(DateFormatUtils.format(date, "dd"));
            GregorianCalendar tempCalendar = new GregorianCalendar(year, month, day);
            tempCalendar.add(6, offsets);
            return tempCalendar.getTime();
        }
    }

    public static int compareDate(Date date1, Date date2) {
        return date1 != null && date2 != null ? date1.compareTo(date2) : -1;
    }

    public static long getUnixTimestamp() {
        return System.currentTimeMillis() / 1000L;
    }

    public static String unixTimestampToDateString(long unixTimestamp, String format) {
        if (null == format) {
            format = parsePatterns[1];
        }

        Date date = new Date(unixTimestamp * 1000L);
        return formatDate(date, format);
    }

    public static void main(String[] args) {
        long unix = getUnixTimestamp();
        System.out.println(unix);
        System.out.println(unixTimestampToDateString(unix, (String)null));
    }
}
