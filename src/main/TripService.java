import java.util.List;

interface TripService {
    int getTotalMilesDriven(List<Trip> trips);

    int getAverageSpeed(List<Trip> trips);

    int getPercentageOfHighwayMiles(List<Trip> trips);

    /**
     * Returns a list of invalid trips based on the problem statement:
     * "Any trips that average a speed of less than 5 mph or greater than 100 mph will be discarded."
     * @param trips
     *      Full list of trips for a driver.
     * @return
     *      A list of invalid trips. Returns empty list of no invalid trips are found.
     */
    List<Trip> getInvalidTrips(List<Trip> trips);
}

