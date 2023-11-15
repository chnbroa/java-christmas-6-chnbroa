package christmas.model;

import static christmas.vaildation.Validation.validateDateRange;

public class ExpectedVisitDate {
    private final int date;

    public ExpectedVisitDate(int date) {
        validateDateRange(date);
        this.date = date;
    }

    @Override
    public String toString() {
        return "12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    }
}
