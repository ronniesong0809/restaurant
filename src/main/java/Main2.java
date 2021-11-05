import java.util.Date;

public class Main2 {
    static Restaurant2 restaurant;
    static Order order;

    public static void main(String[] args) throws NoTableException {
        restaurant = new Restaurant2();
        restaurant.addTable(new Table2(1, 2));
        restaurant.addTable(new Table2(2, 4));
        restaurant.addTable(new Table2(3, 6));
        restaurant.addTable(new Table2(3, 8));

        Table2 table1 = restaurant.findTable(new Party(5));
        //Table2 table2 = restaurant2.findTable(new Party(3));
        takeOrder(table1, 5);

        //table2.reserveForDate(new Date());
        Reservation reservation1 = restaurant.findTableForReservation(new Party(3), new Date());
        Reservation reservation2 = restaurant.findTableForReservation(new Party(5), new Date());

        prints("find table for party of 5, and reserve tables for parties of 3 and 5:", restaurant.restaurantDescription());

        prints("check out table " + table1.getId() + ":", "bills: " + restaurant.checkOut(table1), restaurant.restaurantDescription());

        Table2 table2 = restaurant.redeemReservation(reservation1);
        prints("redeem reservation1:", "assign to table " + table2.getId(), restaurant.restaurantDescription());

        takeOrder(table2, 19);
        prints("table 2 take order:", restaurant.restaurantDescription());

        restaurant.cancelReservation(reservation2);
        prints("cancel reservation2:", restaurant.restaurantDescription());

        Reservation reservation3 = restaurant.findTableForReservation(new Party(3), new Date());
        Reservation reservation4 = restaurant.findTableForReservation(new Party(3), new Date());
        Reservation reservation5 = restaurant.findTableForReservation(new Party(3), new Date());
    }

    private static void prints(String... arr) {
        for (String s : arr)
            System.out.println(s);
    }

    private static void takeOrder(Table2 t, int price) {
        order = new Order();
        Meal meal = new Meal(price);
        order.addMeal(meal);

        restaurant.takeOrder(t, order);
    }
}
