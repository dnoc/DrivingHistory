import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DrivingHistory {
    private static final String NO_TRIPS_OUTPUT_FORMAT = "%s: 0 miles with %d invalid trips.";
    private static final String OUTPUT_FORMAT = "%s: %d miles @ %d mph %d%% highway miles with %d invalid trips.";

    public static void main(String[] args) {
        final String filename = args[0];

        try {
            final TripFileService tripFileService = new TripFileServiceImpl();
            final TripService tripService = new TripServiceImpl();
            final List<Driver> tripData = tripFileService.buildFromFile(filename);

            Collections.sort(tripData);

            for (Driver d : tripData) {
                final List<Trip> trips = d.getTrips();
                final int totalMilesDriven = tripService.getTotalMilesDriven(trips);
                if (totalMilesDriven == 0) {
                    System.out.println(String.format(
                            NO_TRIPS_OUTPUT_FORMAT,
                            d.getName(),
                            tripService.getInvalidTrips(trips).size()));
                } else {
                    System.out.println(String.format(
                            OUTPUT_FORMAT,
                            d.getName(),
                            totalMilesDriven,
                            tripService.getAverageSpeed(trips),
                            tripService.getPercentageOfHighwayMiles(trips),
                            tripService.getInvalidTrips(trips).size()));
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error: Could not read file: " + filename);
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: a general exception has occurred:");
            e.printStackTrace();
        }
    }
}
