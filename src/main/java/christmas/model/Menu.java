package christmas.model;

import static christmas.vaildation.Validation.checkBlank;
import static christmas.vaildation.Validation.containsMenuItem;
import static christmas.vaildation.Validation.isNotNumber;
import static christmas.vaildation.Validation.validateCountRange;

public class Menu {
    private String menu;
    private int number;

    public Menu(String menu, String count) {
        checkBlank(menu);
        containsMenuItem(menu);
        this.menu = menu;
        int number = isNotNumber(count);
        validateCountRange(number);
        this.number = number;
    }


    public String getMenu() {
        return menu;
    }

    public int getNumber() {
        return number;
    }

}
