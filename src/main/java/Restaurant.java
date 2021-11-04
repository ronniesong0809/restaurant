import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private final List<Table> tables;
    private final List<Meal> menu;

    public Restaurant() {
        // Write your code here
        tables = new ArrayList<>();
        menu = new ArrayList<>();
    }

    public Table findTable(Party p) throws NoTableException {
        // Write your code here
        for (Table table : tables) {
            if (table.isAvailable() && table.getCapacity() >= p.getSize()) {
                table.markUnavailable();
                return table;
            }
        }
        throw new NoTableException(p);
    }

    public void takeOrder(Table t, Order o) {
        // Write your code here
        t.setOrder(o);
    }

    public float checkOut(Table t) {
        // Write your code here
        Order currentOrder = t.getCurrentOrder();
        if (currentOrder != null) {
            t.markAvailable();
            t.setOrder(null);
            return currentOrder.getBill();
        }
        return 0;
    }

    public List<Meal> getMenu() {
        return menu;
    }

    public void addTable(Table t) {
        // Write your code here
        tables.add(t);
        Collections.sort(tables);
    }

    public String restaurantDescription() {
        // Keep them, don't modify.
        String description = "";
        for (int i = 0; i < tables.size(); i++) {
            Table table = tables.get(i);
            description += ("Table: " + i + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
            if (table.getCurrentOrder() == null)
                description += " No current order for this table";
            else
                description += " Order price: " + table.getCurrentOrder().getBill();

            description += ".\n";
        }
        description += "*****************************************\n";
        return description;
    }
}
