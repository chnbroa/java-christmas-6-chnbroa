package christmas.model;

public enum MenuItem {
    // Appetizers
    양송이수프("양송이수프", 6_000, "Appetizer"),
    타파스("타파스", 5_500, "Appetizer"),
    시저샐러드("시저샐러드", 8_000, "Appetizer"),

    // Main
    티본스테이크("티본스테이크", 55_000, "Main"),
    바비큐립("바비큐립", 54_000, "Main"),
    해산물파스타("해산물파스타", 35_000, "Main"),
    크리스마스파스타("크리스마스파스타", 25_000, "Main"),

    // Desserts
    초코케이크("초코케이크", 15_000, "Dessert"),
    아이스크림("아이스크림", 5_000, "Dessert"),

    // Beverages
    제로콜라("제로콜라", 3_000, "Beverage"),
    레드와인("레드와인", 60_000, "Beverage"),
    샴페인("샴페인", 25_000, "Beverage");

    private final String itemName;
    private final int price;
    private final String category;

    MenuItem(String itemName, int price, String category) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
