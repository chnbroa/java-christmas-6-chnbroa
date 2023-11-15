package christmas.model;

import static christmas.vaildation.Validation.validateDateRange;

public class ExpectedVisitDate {
    private final int date;

    public ExpectedVisitDate(int date) {
        validateDateRange(date);
        this.date = date;
    }
}
