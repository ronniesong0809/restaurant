import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Table2 implements Comparable<Table2> {
    public static final int HOUR = 3600 * 1000;
    private final int id;
    private final int capacity;
    private boolean available;
    private Order order;
    private final List<Date> reservation;

    public Table2(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.available = true;
        this.order = null;
        this.reservation = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void markAvailable() {
        this.available = true;
    }

    public void markUnavailable() {
        this.available = false;
    }

    public Order getCurrentOrder() {
        return this.order;
    }

    public void setOrder(Order o) {
        if (order == null) {
            this.order = o;
        } else {
            if (o != null) {
                this.order.mergeOrder(o);
            } else {
                this.order = o;
            }
        }
    }

    public List<Date> getReservation() {
        return this.reservation;
    }

    @Override
    public int compareTo(Table2 compareTable) {
        // TODO Auto-generated method stub
        return this.capacity - compareTable.getCapacity();
    }

    private int findDatePosition(Date d) {
        // Write your code here
        int size = reservation.size();

        if (size == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < size; i++) {
            if (reservation.get(i).getTime() < d.getTime() ) {
                result = i;
            }
        }
        return result;
    }

    public boolean noFollowReservation(Date d) {
        // Write your code here
        int index = findDatePosition(d);

        if (index < reservation.size()) {
            long start = reservation.get(index).getTime();
            long end = start + Restaurant2.MAX_DINE_HOUR * Restaurant2.HOUR;
            if (end < d.getTime()) {
                return false;
            }
        }
        return true;
    }

    public boolean reserveForDate(Date d) {
        // Write your code here

        noFollowReservation(d);
        int index = findDatePosition(d);
        reservation.add(index, d);
        // Collections.sort(reservation);

        return true;
    }

    public void removeReservation(Date d) {
        // Write your code here
        reservation.remove(d);
    }
}
