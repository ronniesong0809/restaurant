import java.util.Date;

public class Main {
    static Restaurant restaurant;
    static Order order;

    public static void main(String[] args) throws NoTableException {
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
}
