package christmas.model;

import static christmas.vaildation.Validation.validateDateRange;

import java.util.ArrayList;
import java.util.Arrays;

public class VisitDate {
    private final int date;

    public VisitDate(int date) {
        validateDateRange(date);
        this.date = date;
    }

    public boolean checkDdayDiscount() {
        if (date < 1 || date > 25) {
            return false;
        }
        return true;
    }

    public int getDdayDiscount() {
        return 1000 + (date - 1) * 100;
    }

    public boolean isWeekendDay() {
        if (date % 7 == 1 || date % 7 == 2) {
            return true;
        }
        return false;
    }

    public boolean hasSpecialDiscount() {
        ArrayList<Integer> specialDay = new ArrayList<>(Arrays.asList(3, 10, 17, 24, 25, 31));

        return specialDay.contains(date);
    }

    @Override
    public String toString() {
        return "12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    }
}
