package christmas.controller;

import static christmas.vaildation.Validation.OnlyDrinksOrdered;

import christmas.model.ExpectedVisitDate;
import christmas.model.OrderMenu;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChrismasController {
    private final InputView inputView;
    private final OutputView outputView;
    private ExpectedVisitDate expectedVisitDate;
    private OrderMenu orderMenu;

    public ChrismasController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printHelloMessage();
        expectedVisitDate = inputVisitDate();
        orderMenu = inputMenu();
        outputView.printOrderMenu(expectedVisitDate, orderMenu);
        outputView.printTotalAmount(orderMenu);
        outputView.printFreeMenu(orderMenu);
    }

    private ExpectedVisitDate inputVisitDate() {
        while (true) {
            try {
                return new ExpectedVisitDate(inputView.inputDate());
            } catch (IllegalArgumentException e) {
                outputView.printDateError();
            }
        }
    }

    private OrderMenu inputMenu() {
        while (true) {
            try {
                OrderMenu menu = new OrderMenu(inputView.inputMenu());
                OnlyDrinksOrdered(menu);
                return menu;
            } catch (IllegalArgumentException e) {
                outputView.printMenuError();
            }
        }
    }
}
