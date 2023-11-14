package christmas.view.exception;

public class IsNotNumberException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 입력값이 숫자가 아닙니다. 다시 입력해 주세요";

    public IsNotNumberException() {
        super(ERROR_MESSAGE);
    }
}
