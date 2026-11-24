import java.time.LocalDate;
public abstract class Ticket {
    public enum TicketStatus { ACTIVE, USED, EXPIRED, REFUNDED }
    private static int nextId = 1000;
    private int id;
    private String tripId;
    private final String start;
    private final String destination;
    private final int stations;
    private LocalDate issueDate;
    private TicketStatus status;

    /** Protected so only this class and its subclasses can call it. */
    protected Ticket(String start, String destination, int stations) {
        this.id = nextId++;
        this.tripId = "TRP-" + id;
        this.start = start;
        this.destination = destination;
        this.stations = stations;
        this.issueDate = LocalDate.now();
        this.status = TicketStatus.ACTIVE;
    }

    public abstract double getPrice();
    public abstract String getTypeName();

    public boolean isValid(String exitStation) {
        return status == TicketStatus.ACTIVE && destination.equals(exitStation);
    }

    /** Uses the ticket: sets status to USED if valid. */
    public boolean consumeRide(String exitStation) {
        if (!isValid(exitStation)) return false;
        status = TicketStatus.USED;
        return true;
    }

    /** Cancels an active ticket and marks it REFUNDED. */
    public boolean cancelAndRefund() {
        if (status != TicketStatus.ACTIVE) return false;
        status = TicketStatus.REFUNDED;
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
        if (stations >= 24 && stations <= 39)
            return new FourLinesTicket(start, destination, stations);

        throw new IllegalArgumentException("Invalid stations: " + stations);
    }
    /** Saves the ticket as one comma-separated line. */
    public String toFileString() {
        return String.join(",", String.valueOf(id), tripId, start,
                destination, String.valueOf(stations), issueDate.toString(), status.name());
    }

    /** Rebuilds a ticket from a line written by toFileString(). */
    public static Ticket fromFileString(String line) {
        String[] p = line.split(",");
        Ticket t = issue(p[2], p[3], Integer.parseInt(p[4]));
        t.restore(Integer.parseInt(p[0]), p[1], LocalDate.parse(p[5]), TicketStatus.valueOf(p[6]));
        return t;
    }

    /** Overwrites the generated values with the saved ones. */
    private void restore(int id, String tripId, LocalDate issueDate, TicketStatus status) {
        this.id = id;
        this.tripId = tripId;
        this.issueDate = issueDate;
        this.status = status;
        nextId = Math.max(nextId, id + 1);
    }

    public int getId() { return id; }
    public String getTripId() { return tripId; }
    public String getStart() { return start; }
    public String getDestination() { return destination; }
    public int getStations() { return stations; }
    public LocalDate getIssueDate() { return issueDate; }
    public TicketStatus getStatus() { return status; }

    @Override
    public String toString() {
        return getTypeName() + " #" + id + " " + start + " -> " + destination
                + " | " + getPrice() + " EGP | " + status;
    }
}

// the price depends on the number of lines
class OneLineTicket extends Ticket {
    OneLineTicket(String s, String d, int n) { super(s, d, n); }
    @Override public double getPrice() { return 10.0; }
    @Override public String getTypeName() { return "One Line"; }
}

class TwoLinesTicket extends Ticket {
    TwoLinesTicket(String s, String d, int n) { super(s, d, n); }
    @Override public double getPrice() { return 12.0; }
    @Override public String getTypeName() { return "Two Lines"; }
}

class ThreeLinesTicket extends Ticket {
    ThreeLinesTicket(String s, String d, int n) { super(s, d, n); }
    @Override public double getPrice() { return 16.0; }
    @Override public String getTypeName() { return "Three Lines"; }
}

class FourLinesTicket extends Ticket {
    FourLinesTicket(String s, String d, int n) { super(s, d, n); }
    @Override public double getPrice() { return 20.0; }
    @Override public String getTypeName() { return "Four Lines"; }
}
