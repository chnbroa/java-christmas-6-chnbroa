package christmas.vaildation;

import christmas.view.exception.InvalidDateException;
import christmas.view.exception.IsNotNumberException;

public class Validation {
    public static int isNotNumber(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IsNotNumberException();
        }
    }

    public static void isNotInValidRange(int date) {
        if (date < 1 || date > 31) {
            throw new InvalidDateException();
        }
    }
}
