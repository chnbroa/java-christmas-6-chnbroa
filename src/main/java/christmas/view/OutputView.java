package christmas.view;

import static christmas.service.Service.calculateFreeMenu;

import christmas.model.Event;
import christmas.model.OrderMenu;
import christmas.model.VisitDate;
import java.text.NumberFormat;

public class OutputView {
    private static final String HELLO_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String DATE_ERROR_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static final String MENU_ERROR_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_AMOUNT = "<할인 전 총주문 금액>";
    private static final String FREE_MENU = "<증정 메뉴>";
    private static final String BENEFIT_DETAILS = "<혜택 내역>";
    private NumberFormat numberFormat;

    public OutputView() {
        numberFormat = NumberFormat.getNumberInstance();
    }

    public void printHelloMessage() {
        System.out.println(HELLO_MESSAGE);
    }

    public void printDateError() {
        System.out.println(DATE_ERROR_MESSAGE);
    }

    public void printMenuError() {
        System.out.println(MENU_ERROR_MESSAGE);
    }

    public void printOrderMenu(VisitDate date, OrderMenu orderMenu) {
        System.out.println(date.toString());
        System.out.println(ORDER_MENU);
        System.out.println(orderMenu.toString());
    }

    public void printTotalAmount(OrderMenu orderMenu) {
        System.out.println(TOTAL_AMOUNT);
        System.out.println(numberFormat.format(orderMenu.getTotalAmount()) + "원");
        System.out.println();
    }

    public void printFreeMenu(OrderMenu orderMenu) {
        System.out.println(FREE_MENU);
        System.out.println(calculateFreeMenu(orderMenu.getTotalAmount()));
        System.out.println();
    }

    public void printBenefitDetails(Event event) {
        System.out.println(BENEFIT_DETAILS);
        if (event.getTotalDiscount() == 0) {
            System.out.println("없음");
            return;
        }
        printDdayDiscount(event.getDayDiscount());
        printWeekdayDiscount(event.getWeekdayDiscount());
        printWeekendDiscount(event.getWeekendDiscount());
        printSpecialDiscount(event.getSpecialDiscount());
        printGiveawayDiscount(event.getGiveawayDiscount());
        System.out.println();
    }

    private void printDdayDiscount(int rate) {
        if (rate != 0) {
            System.out.println("크리스마스 디데이 할인: -" + numberFormat.format(rate) + "원");
        }

    }

    private void printWeekdayDiscount(int rate) {
        if (rate != 0) {
            System.out.println("평일 할인: -" + numberFormat.format(rate) + "원");
        }
    }

    private void printWeekendDiscount(int rate) {
        if (rate != 0) {
            System.out.println("주말 할인: -" + numberFormat.format(rate) + "원");
        }
    }

    private void printSpecialDiscount(int rate) {
        if (rate != 0) {
            System.out.println("특별 할인: -" + numberFormat.format(rate) + "원");
        }
    }

    private void printGiveawayDiscount(int rate) {
        if (rate != 0) {
            System.out.println("증정 이벤트: -" + numberFormat.format(rate) + "원");
        }
    }

}
