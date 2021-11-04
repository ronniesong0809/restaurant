import java.util.Date;

public class Main {
    static Restaurant restaurant;
    static Order order;
    static Restaurant2 restaurant2;
    static Order order2;

    public static void main(String[] args) throws NoTableException {
        restaurantI();
        restaurantII();
    }

    private static void restaurantII() throws NoTableException {
        restaurant2 = new Restaurant2();
        restaurant2.addTable(new Table2(1, 2));
        restaurant2.addTable(new Table2(2, 4));
        restaurant2.addTable(new Table2(3, 6));

        Table2 table1 = restaurant2.findTable(new Party(5));
        Table2 table2 = restaurant2.findTable(new Party(3));

        takeOrder2(table1, 1);
        table2.reserveForDate(new Date());

        System.out.println(restaurant2.restaurantDescription());
    }

    private static void restaurantI() throws NoTableException {
        restaurant = new Restaurant();
        restaurant.addTable(new Table(2));
        restaurant.addTable(new Table(4));
        restaurant.addTable(new Table(6));

        // find table
        Table table1 = restaurant.findTable(new Party(5));
        Table table2 = restaurant.findTable(new Party(1));

        // take order
        takeOrder(table1, 1);
        takeOrder(table1, 2);
        takeOrder(table2, 5);

        //
        // System.out.println(restaurant.restaurantDescription());
        restaurant.checkOut(table2);
        // System.out.println(restaurant.restaurantDescription());
    }

    private static void takeOrder(Table t, int price) {
        order = new Order();
        Meal meal = new Meal(price);
        order.addMeal(meal);

        restaurant.takeOrder(t, order);
    }

    private static void takeOrder2(Table2 t, int price) {
        order = new Order();
        Meal meal = new Meal(price);
        order.addMeal(meal);

        restaurant2.takeOrder(t, order);
    }
}
