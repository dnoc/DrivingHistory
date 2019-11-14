import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TripServiceImpl implements TripService {

    public TripServiceImpl() {}

    @Override
    public int getTotalMilesDriven(List<Trip> trips) {
        if (trips == null) return 0;

        int sum = 0;
        for (Trip t : trips) {
            sum += Math.round(t.getMilesDriven());
        }

        return sum;
    }

    @Override
    public int getAverageSpeed(List<Trip> trips) {
        if (trips == null || trips.size() == 0) return 0;

        float totalMiles = 0;
        float totalDuration = 0;
        for (Trip t : trips) {
            totalMiles += t.getMilesDriven();
            totalDuration += t.getDurationInHours();
        }

        return Math.round(totalMiles / totalDuration);
    }

    @Override
    public int getPercentageOfHighwayMiles(List<Trip> trips) {
        if (trips == null || trips.size() == 0) return 0;

        float totalMiles = 0;
        float totalHighwayMiles = 0;
        for (Trip t : trips) {
            if (t.isHighwayTrip()) {
                totalHighwayMiles += t.getMilesDriven();
            }
            totalMiles += t.getMilesDriven();
        }
        final float percentage = (totalHighwayMiles / totalMiles) * 100.0f;

        return Math.round(percentage);
    }

    @Override
    public List<Trip> getInvalidTrips(List<Trip> trips) {
        if (trips == null) return new ArrayList<>();

        return trips
                .stream()
                .filter(t -> (t.getSpeed() < 5) || (t.getSpeed() > 100))
                .collect(Collectors.toList());
    }
}
