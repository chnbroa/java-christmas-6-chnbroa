package christmas;


import static christmas.vaildation.Validation.checkBlank;
import static christmas.vaildation.Validation.checkComma;
import static christmas.vaildation.Validation.checkDash;
import static christmas.vaildation.Validation.checkListSize;
import static christmas.vaildation.Validation.containsMenuItem;
import static christmas.vaildation.Validation.isNotNumber;
import static christmas.vaildation.Validation.validateCountRange;
import static christmas.vaildation.Validation.validateDateRange;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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

        assertThatThrownBy(() -> validateDateRange(date))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 앞뒤 쉼표를 포함한 경우")
    @Test
    void checkCommaTest() {
        String str1 = ",제로콜라-1,아이스크림-1";
        String str2 = "제로콜라-1,아이스크림-1,";

        assertThatThrownBy(() -> checkComma(str1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checkComma(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자열 앞뒤 다시를 포함한 경우")
    @Test
    void checkDashTest() {
        String str1 = "제로콜라-1-";
        String str2 = "-제로콜라-1";

        assertThatThrownBy(() -> checkDash(str1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checkDash(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("2개로 분리되지 않는 경우")
    @Test
    void checkListSizeTest() {
        List<String> str1 = List.of("제로콜라", "1", " ");

        assertThatThrownBy(() -> checkListSize(str1))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("값이 없는 경우")
    @Test
    void checkBlankTest() {
        String str1 = " ";
        String str2 = null;

        assertThatThrownBy(() -> checkBlank(str1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> checkBlank(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값이 0보다 작거나 20보다 큰 경우")
    @Test
    void validateCountRangeTest() {
        int num1 = 0;
        int num2 = 21;

        assertThatThrownBy(() -> validateCountRange(num1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validateCountRange(num2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 형식이 예시와 다른 경우")
    @Test
    void containsMenuItemTest() {
        String str1 = "제로팹시";
        String str2 = "콜라제로";

        assertThatThrownBy(() -> containsMenuItem(str1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> containsMenuItem(str2))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
