package christmas.controller;

import christmas.view.InputView;

public class ChrismasController {
    private final InputView inputView;

    public ChrismasController() {
        inputView = new InputView();
    }

    public void start() {
        inputView.printHelloMessage();
    }
}
