package christmas;

import static christmas.vaildation.Validation.isNotInValidRange;
import static christmas.vaildation.Validation.isNotNumber;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChrismasTest {
    @DisplayName("숫자가 아닌 경우")
    @Test
    void isNotNumberTest() {
        String number = "a";

        assertThatThrownBy(() -> isNotNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~31 사이의 숫자가 아닌 경우")
    @Test
    void isNotInValidRangeTest() {
        int date = 0;

        assertThatThrownBy(() -> isNotInValidRange(date))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
