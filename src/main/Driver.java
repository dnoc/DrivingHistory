import java.util.ArrayList;
import java.util.List;

public class Driver {

    private String name;
    private List<Trip> trips;

    public Driver(final String name) {
        this.name = name;
        this.trips = new ArrayList<>();
    }

    public Driver(final String name, final List<Trip> trips) {
        this.name = name;
        this.trips = trips;
    }

    public String getName() {
        return name;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void addTrip(final Trip trip) {
        this.trips.add(trip);
    }
}
