import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Restaurant2 {
    public static final int MAX_DINE_HOUR = 2;
    public static final long HOUR = 3600 * 1000;
    private final List<Table2> tables;
    private final List<Meal> menu;

    public Restaurant2() {
        // Write your code here
        tables = new ArrayList<>();
        menu = new ArrayList<>();
    }

    public Table2 findTable(Party p) throws NoTableException {
        // Write your code here
        for (Table2 table : tables) {
            if (table.isAvailable() && table.getCapacity() >= p.getSize()) {
                table.markUnavailable();
                return table;
            }
        }
        throw new NoTableException(p);
    }

    public void takeOrder(Table2 t, Order o) {
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

    public void addTable(Table2 t) {
        // Write your code here
        tables.add(t);
        Collections.sort(tables);
    }

    public Reservation findTableForReservation(Party p, Date date) {
        // Write your code here
        return null;
    }

    public void cancelReservation(Reservation r) {
        Date date = r.getDate();
        r.getTable().removeReservation(date);
    }

    public void redeemReservation(Reservation r) {
        Date date = r.getDate();
        Table2 table = r.getTable();

        table.markUnavailable();
        table.removeReservation(date);
    }

    public String restaurantDescription() {
        String description = "";
        for (int i = 0; i < tables.size(); i++) {
            Table2 table = tables.get(i);
            description += ("Table: " + table.getId() + ", table size: " + table.getCapacity() + ", isAvailable: " + table.isAvailable() + ".");
            if (table.getCurrentOrder() == null)
                description += " No current order for this table";
            else
                description += " Order price: " + table.getCurrentOrder().getBill();

            description += ". Current reservation dates for this table are: ";

            for (Date date : table.getReservation()) {
                description += date.toGMTString() + " ; ";
            }

            description += ".\n";
        }
        description += "*****************************************\n";
        return description;
    }
}
