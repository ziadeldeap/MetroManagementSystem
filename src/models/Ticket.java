
package models;
import java.time.LocalDate;
enum TicketStatus { ACTIVE, USED, EXPIRED, REFUNDED }
/** Abstraction: defines what every ticket has and does. Subclasses decide the price. */
abstract class Ticket {
    private static int nextId = 1000;
    private final int id;
    private final String start;
    private final String destination;
    private final int stations;
    private final LocalDate issueDate;
    private TicketStatus status;

    /** The constructor of the class, "protected" is for protection
     * of the variables I set so no one can reach them */
    protected Ticket(String start, String destination, int stations) {
        this.id = nextId++;
        this.start = start;
        this.destination = destination;
        this.stations = stations;
        this.issueDate = LocalDate.now();
        this.status = TicketStatus.ACTIVE;
    }

    /** because these operations must be private, so we put them
     * n abstract classes, Abstract classes does not accept any code inside
     * so we use polymorphism to override them */
    public abstract double getPrice();
    public abstract String getTypeName();

    // the user exit successfully or not
    public boolean isValid(String exitStation) {
        return status == TicketStatus.ACTIVE && destination.equals(exitStation);
    }

    /** Uses the ticket: sets status to USED if valid. */
    public boolean consumeRide(String exitStation) {
        if (!isValid(exitStation)) return false;
        status = TicketStatus.USED;
        return true;
    }

    /** Picks the right subclass based on the number of stations. */
    public static Ticket issue(String start, String destination, int stations) {
        if (stations > 0 && stations <= 9)
            return new OneLineTicket(start, destination, stations);
        if (stations >= 10 && stations <= 16)
            return new TwoLinesTicket(start, destination, stations);
        if (stations >= 17 && stations <= 23)
            return new ThreeLinesTicket(start, destination, stations);
        if (stations >= 10 && stations <= 39)
            return new FourLinesTicket(start, destination, stations);

        throw new IllegalArgumentException("Invalid stations: " + stations);
    }

    public int getId() {
        return id;
    }
    public TicketStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getTypeName() + " #" + id + " " + start + " -> " + destination
                + " | " + getPrice() + " EGP | " + status;
    }
}

// the price depends on the number of lines
class OneLineTicket extends Ticket {
    OneLineTicket(String s, String d, int n) { super(s, d, n); }
    @Override public double getPrice() {
        return 10.0;
    }
    @Override public String getTypeName() {
        return "One Line";
    }
}

class TwoLinesTicket extends Ticket {
    TwoLinesTicket(String s, String d, int n) {
        super(s, d, n);
    }
    @Override public double getPrice() {
        return 12.0;
    }
    @Override public String getTypeName() {
        return "Two Lines";
    }
}

class ThreeLinesTicket extends Ticket {
    ThreeLinesTicket(String s, String d, int n) {
        super(s, d, n);
    }
    @Override public double getPrice() {
        return 16.0;
    }
    @Override public String getTypeName() {
        return "Three Lines";
    }
}

class FourLinesTicket extends Ticket {
    FourLinesTicket(String s, String d, int n) {
        super(s, d, n);
    }
    @Override public double getPrice() {
        return 20.0;
    }
    @Override public String getTypeName() {
        return "Four Lines";
    }
}
