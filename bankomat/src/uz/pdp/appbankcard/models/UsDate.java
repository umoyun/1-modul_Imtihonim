package uz.pdp.appbankcard.models;

public class UsDate {
    private int day;
    private int month;
    private int year;

    public UsDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public UsDate(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {

        if(day == 0){
            return String.format("%02d/%02d", month, year%100);
        }

        return String.format("%02d.%02d.%04d", day, month, year);
    }
}
