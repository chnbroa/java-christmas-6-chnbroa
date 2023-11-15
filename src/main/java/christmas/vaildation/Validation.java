package christmas.vaildation;

import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.OrderMenu;
import christmas.view.exception.DuplicateMenuException;
import christmas.view.exception.EmptyStringException;
import christmas.view.exception.InvalidCountException;
import christmas.view.exception.InvalidDateException;
import christmas.view.exception.InvalidFormatException;
import christmas.view.exception.InvalidListSizeException;
import christmas.view.exception.IsNotNumberException;
import christmas.view.exception.MenuItemNotFoundException;
import christmas.view.exception.OnlyDrinksOrderedException;
import java.util.List;
import java.util.Map;

public class Validation {
    private static final char COMMA = ',';
    private static final char DASH = '-';
    private static final int MAX_DATE = 31;
    private static final int MIN_DATE = 1;
    private static final int MAX_ORDER_NUMBER = 20;

    private static final int MIN_ORDER_NUMBER = 0;


    public static int isNotNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IsNotNumberException();
        }
    }

    public static void validateDateRange(int date) {
        if (date < MIN_DATE || date > MAX_DATE) {
            throw new InvalidDateException();
        }
    }

    public static void checkComma(String str) {
        if (str.charAt(0) == COMMA || str.charAt(str.length() - 1) == COMMA) {
            throw new InvalidFormatException();
        }
    }

    public static void checkDash(String str) {
        if (str.charAt(0) == DASH || str.charAt(str.length() - 1) == DASH) {
            throw new InvalidFormatException();
        }
    }

    public static void checkListSize(List<String> menu) {
        if (menu.size() != 2) {
            throw new InvalidListSizeException();
        }
    }

    public static void checkBlank(String menu) {
        if (menu == null || menu.isBlank()) {
            throw new EmptyStringException();
        }
    }

    public static void validateCountRange(int count) {
        if (count <= MIN_ORDER_NUMBER || count > MAX_ORDER_NUMBER) {
            throw new InvalidCountException();
        }
    }

    public static void checkForDuplicateMenu(Map<String, Integer> orderMenu, List<Menu> menu) {
        if (orderMenu.size() != menu.size()) {
            throw new DuplicateMenuException();
        }
    }

    public static void containsMenuItem(String menu) {
        try {
            MenuItem.valueOf(menu);
        } catch (IllegalArgumentException e) {
            throw new MenuItemNotFoundException();
        }
    }

    public static void OnlyDrinksOrdered(OrderMenu orderMenu) {
        if (orderMenu.getSumCount() == orderMenu.categoryCalculator("Beverage")) {
            throw new OnlyDrinksOrderedException();
        }
    }
}