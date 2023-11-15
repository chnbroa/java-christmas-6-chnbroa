package christmas.service;

import static christmas.vaildation.Validation.checkDash;
import static christmas.vaildation.Validation.checkListSize;

import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    private static final String DASH = "-";

    public static List<String> splitStringToList(String menu, String delimiter) {
        return new ArrayList<>(Arrays.asList(menu.split(delimiter)));
    }

    public static List<Menu> parseMenuItems(List<String> menuItems) {
        List<Menu> menus = new ArrayList<>();
        for (String item : menuItems) {
            checkDash(item);
            List<String> splitDash = splitStringToList(item, DASH);
            checkListSize(splitDash);
            menus.add(new Menu(splitDash.get(0), splitDash.get(1)));
        }
        return menus;
    }

    public static String calculateFreeMenu(int totalAmount) {
        if (totalAmount > 120000) {
            return "샴페인 1개";
        }
        return "없음";
    }

    private static boolean checkTotalAmount(OrderMenu orderMenu) {
        if (orderMenu.getTotalAmount() > 10000) {
            return false;
        }
        return true;
    }


    private static int dayDiscount(VisitDate date) {
        if (date.checkDdayDiscount()) {
            return date.getDdayDiscount();
        }
        return 0;
    }

    private static int weekdayDiscount(OrderMenu orderMenu, VisitDate date) {
        if (!date.isWeekendDay()) {
            return orderMenu.categoryCalculator("Dessert") * 2023;
        }
        return 0;
    }

    private static int weekendDiscount(OrderMenu orderMenu, VisitDate date) {
        if (date.isWeekendDay()) {
            return orderMenu.categoryCalculator("Main") * 2023;
        }
        return 0;
    }

    private static int specialDiscount(VisitDate date) {
        if (date.hasSpecialDiscount()) {
            return 1000;
        }
        return 0;
    }

    private static int giveawayDiscount(OrderMenu orderMenu) {
        if (orderMenu.getTotalAmount() > 120000) {
            return 25000;
        }
        return 0;
    }

    public static Event checkEvent(OrderMenu orderMenu, VisitDate date) {
        Event event;
        int[] rate = new int[5];

        if (checkTotalAmount(orderMenu)) {
            return new Event(rate);
        }
        rate[0] = dayDiscount(date);
        rate[1] = weekdayDiscount(orderMenu, date);
        rate[2] = weekendDiscount(orderMenu, date);
        rate[3] = specialDiscount(date);
        rate[4] = giveawayDiscount(orderMenu);
        return new Event(rate);
    }

}
