package christmas.controller;

import static christmas.service.Service.checkEvent;
import static christmas.vaildation.Validation.OnlyDrinksOrdered;

import christmas.model.Event;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChrismasController {
    private final InputView inputView;
    private final OutputView outputView;
    private VisitDate visitDate;
    private OrderMenu orderMenu;
    private Event event;

    public ChrismasController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void start() {
        outputView.printHelloMessage();
        visitDate = inputVisitDate();
        orderMenu = inputMenu();
        outputView.printOrderMenu(visitDate, orderMenu);
        outputView.printTotalAmount(orderMenu);
        outputView.printFreeMenu(orderMenu);
        event = checkEvent(orderMenu, visitDate);
        outputView.printBenefitDetails(event);
        outputView.printTotalBenefitAmount(event);
        outputView.printExoectedAmount(event.getExoectedAmount(orderMenu.getTotalAmount()));
        outputView.printBadge(event);
    }

    private VisitDate inputVisitDate() {
        while (true) {
            try {
                return new VisitDate(inputView.inputDate());
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
