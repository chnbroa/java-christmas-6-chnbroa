package christmas.model;

import static christmas.vaildation.Validation.isNotInValidRange;

public class ExpectedVisitDate {
    private final int date;

    public ExpectedVisitDate(int date) {
        isNotInValidRange(date);
        this.date = date;
    }
}
