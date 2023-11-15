package christmas.model;

import static christmas.vaildation.Validation.checkForDuplicateMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMenu {
    private final Map<String, Integer> orderMenu;

    public OrderMenu(List<Menu> menu) {
        this.orderMenu = listToMap(menu);
        checkForDuplicateMenu(orderMenu, menu);
    }

    private Map<String, Integer> listToMap(List<Menu> menu) {
        Map<String, Integer> map = new HashMap<>();
        for (Menu item : menu) {
            map.put(item.getMenu(), item.getNumber());
        }
        return map;
    }

    public int categoryCalculator(String category) {
        int sum = 0;
        for (String menu : orderMenu.keySet()) {
            MenuItem menuItem = MenuItem.valueOf(menu);
            if (menuItem.getCategory().equals(category)) {
                sum += orderMenu.get(menu);
            }
        }
        return sum;
    }

    public int getSumCount() {
        int sum = 0;
        for (String menu : orderMenu.keySet()) {
            sum += orderMenu.get(menu);
        }

        return sum;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> menu : orderMenu.entrySet()) {
            stringBuilder.append(menu.getKey()).append(" ").append(menu.getValue()).append("개\n");
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}


