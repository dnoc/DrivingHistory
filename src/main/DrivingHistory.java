import java.io.IOException;
import java.util.List;

public class DrivingHistory {


    public static void main(String[] args) {
        final String filename = args[0];

        try {
            final TripDataService tripDataService = new TripDataServiceImpl();
            final List<Driver> tripData = tripDataService.buildFromFile(filename);

            System.out.println(tripData.toString());
        } catch (IOException ioe) {
            System.out.println("Error: Could not read file: " + filename);
            ioe.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error: a general exception has occurred:");
            e.printStackTrace();
        }
    }
}
