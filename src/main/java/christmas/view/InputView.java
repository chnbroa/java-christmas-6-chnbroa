package christmas.view;

import static christmas.vaildation.Validation.isNotNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public int inputDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        return isNotNumber(Console.readLine());
    }


}
