package utils;

import java.text.SimpleDateFormat;

public class TimeConverter {

    SimpleDateFormat nowTimeFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm");
    String nowTime = nowTimeFormat.format(System.currentTimeMillis());

    public void setYear(String oldTime) {
        getRestYear(Integer.parseInt(oldTime.substring(0, 4)));
    }

    public void setMonth(String oldTime) {
        getRestMonth(Integer.parseInt(oldTime.substring(5, 7)));
    }

    public void setDate(String oldTime) {
        getRestDate(Integer.parseInt(oldTime.substring(8, 10)));
    }

    public void setHour(String oldTime) {
        getRestHour(Integer.parseInt(oldTime.substring(11, 13)));
    }

    public void setMinute(String oldTime) {
        getRestMinute(Integer.parseInt(oldTime.substring(14, 16)));
    }

    public int getRestYear(int year) {
        int nowTimeYear = Integer.parseInt(nowTime.substring(0, 4));
        return nowTimeYear - year;
    }
    
    public int getRestMonth(int month) {
        int nowTimeMonth = Integer.parseInt(nowTime.substring(5, 7));
        return nowTimeMonth - month;
    }
    
    public int getRestDate(int date) {
        int nowTimeDate = Integer.parseInt(nowTime.substring(8, 10));
        return nowTimeDate - date;
    }
    
    public int getRestHour(int hour) {
        int nowTimeHour = Integer.parseInt(nowTime.substring(11, 13));
        return nowTimeHour - hour;
    }
    
    public int getRestMinute(int minute) {
        int nowTimeMinute = Integer.parseInt(nowTime.substring(14, 16));
        return nowTimeMinute - minute;
    }
}
