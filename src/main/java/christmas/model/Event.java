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

}
