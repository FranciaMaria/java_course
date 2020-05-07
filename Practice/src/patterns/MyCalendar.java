package patterns;

public class MyCalendar {

    private static MyCalendar instance;
    private int year;
    private int month;
    private int day;

    public MyCalendar(){
        this.year = 2020;
        this.month = 1;
        this.day = 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static MyCalendar getInstance() {
        if (instance == null) {
            instance = new MyCalendar();
        }
        return instance;
    }

}
