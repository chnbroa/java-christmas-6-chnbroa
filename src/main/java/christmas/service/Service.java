package christmas.service;

import static christmas.vaildation.Validation.checkDash;
import static christmas.vaildation.Validation.checkListSize;

import christmas.model.Menu;
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


}
