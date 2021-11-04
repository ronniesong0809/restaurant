import java.util.Date;

public class Reservation {
    private Table2 table;
    private Date date;

    public Reservation(Table2 table, Date date)
    {
        this.table = table;
        this.date = date;
    }

    public Date getDate()
    {
        return date;
    }

    public Table2 getTable()
    {
        return table;
    }
}
