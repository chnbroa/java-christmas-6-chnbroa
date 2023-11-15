package christmas.view;

import static christmas.service.Service.parseMenuItems;
import static christmas.service.Service.splitStringToList;
import static christmas.vaildation.Validation.checkComma;
import static christmas.vaildation.Validation.isNotNumber;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.Menu;
import java.util.List;

public class InputView {
    private static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String INPUT_MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private static final String COMMA = ",";


    public int inputDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        return isNotNumber(Console.readLine());
    }

    public List<Menu> inputMenu() {
        System.out.println(INPUT_MENU_MESSAGE);
        String menu = Console.readLine();
        checkComma(menu);
        return parseMenuItems(splitStringToList(menu, COMMA));
    }
}
