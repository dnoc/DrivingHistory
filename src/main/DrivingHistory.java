import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DrivingHistory {


    public static void main(String[] args) {
        final String filename = args[0];

        try {
            final TripDataService tripDataService = new TripDataServiceImpl();
            final List<Driver> tripData = tripDataService.buildFromFile(filename);

            Collections.sort(tripData);

            for (Driver d : tripData) {
                if (d.getTotalMilesDriven() == 0) {
                    System.out.println(d.getName() + ": 0 miles");
                } else {
                    System.out.println(d.getName() + ": " + d.getTotalMilesDriven() + " miles @ " + d.getAverageSpeed() + " mph");
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
