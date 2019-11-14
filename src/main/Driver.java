import java.util.ArrayList;
import java.util.List;

public class Driver implements Comparable<Driver> {

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

    @Override
    public int compareTo(final Driver o) {
        if (this == o) return 0;
        if (o == null) return 1;
        if (this.trips == null) return -1;

        final TripService service = new TripServiceImpl();
        final int tripResult = Integer.compare(
                service.getTotalMilesDriven(o.trips),
                service.getTotalMilesDriven(this.trips));

        if (tripResult == 0) {
            return o.getName().compareTo(this.name);
        } else {
            return tripResult;
        }
    }
}
