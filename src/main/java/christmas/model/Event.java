package christmas.model;

public class Event {

    private int dayDiscount;
    private int weekdayDiscount;
    private int weekendDiscount;
    private int specialDiscount;
    private int giveawayDiscount;


    public Event(int[] rate) {
        this.dayDiscount = rate[0];
        this.weekdayDiscount = rate[1];
        this.weekendDiscount = rate[2];
        this.specialDiscount = rate[3];
        this.giveawayDiscount = rate[4];
    }

    public int getDayDiscount() {
        return dayDiscount;
    }

    public int getWeekdayDiscount() {
        return weekdayDiscount;
    }

    public int getWeekendDiscount() {
        return weekendDiscount;
    }

    public int getSpecialDiscount() {
        return specialDiscount;
    }

    public int getGiveawayDiscount() {
        return giveawayDiscount;
    }

    public int getTotalDiscount() {
        return dayDiscount + weekdayDiscount + weekendDiscount + specialDiscount + giveawayDiscount;
    }

    public int getExoectedAmount(int total) {
        return total - (dayDiscount + weekdayDiscount + weekendDiscount + specialDiscount);
    }

    public String getBadge() {
        if (getTotalDiscount() > 20000) {
            return "산타";
        }
        if (getTotalDiscount() > 10000) {
            return "트리";
        }
        if (getTotalDiscount() > 5000) {
            return "별";
        }
        return "없음";
    }
}
