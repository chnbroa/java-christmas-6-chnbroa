package christmas.view;

public class OutputView {
    private static final String HELLO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public void printDateError() {
        System.out.println(DATE_ERROR_MESSAGE);
    }

    public void printMenuError() {
        System.out.println(MENU_ERROR_MESSAGE);
    }
}
