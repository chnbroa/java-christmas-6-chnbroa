package christmas.controller;

import christmas.model.ExpectedVisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChrismasController {
    private final InputView inputView;
    private final OutputView outputView;
    private ExpectedVisitDate expectedVisitDate;

    public ChrismasController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printHelloMessage();
        inputVisitDate();
    }

    private void inputVisitDate() {
        while (true) {
            try {
                expectedVisitDate = new ExpectedVisitDate(inputView.inputDate());
                return;
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
            }
        }
    }
}
