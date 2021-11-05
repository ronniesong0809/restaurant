import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;


public class TableTest {

    @Test
    public void createTable() {
        Table2 t = new Table2(2, 4);
        assertThat(t.getId()+"", containsString("2"));
    }

    @Test
    public void checkReservation() {
        Table2 t = new Table2(2, 4);
        t.reserveForDate(new Date("Thu Nov 04 19:00:00 PDT 2021"));
        assertThat(t.getReservation().toString(), containsString(new Date("Thu Nov 04 19:00:00 PDT 2021").toString()));
    }

    @Test
    public void checkMultiReservation() {
        Table2 t = new Table2(2, 4);
        t.reserveForDate(new Date("Thu Nov 04 20:00:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 19:00:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 21:00:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 22:00:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 19:30:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 19:45:00 PDT 2021"));
        t.reserveForDate(new Date("Thu Nov 04 19:15:00 PDT 2021"));
        assertThat(t.getReservation().toString(), containsString(new Date("Thu Nov 04 15:00:00 PDT 2021").toString()));
    }
}
