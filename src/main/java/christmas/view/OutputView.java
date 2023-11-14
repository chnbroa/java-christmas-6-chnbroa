package christmas.view;

public class OutputView {
    private static final String HELLO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public void printError(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

}
