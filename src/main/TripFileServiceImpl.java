import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TripFileServiceImpl implements TripFileService {

    private static final String DRIVER_PREFIX = "Driver";
    private static final String TRIP_PREFIX = "Trip";

    public TripFileServiceImpl() {}

    public List<Driver> buildFromFile(final String filename) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        final List<Driver> driverList = new ArrayList<>();
        while ((line = reader.readLine()) != null) {

            if (line.startsWith(DRIVER_PREFIX)) {
                processDriverLine(line, driverList);

            } else if (line.startsWith(TRIP_PREFIX)) {
                processTripLine(line, driverList);

            } else {
                System.out.println("Failed to process input: " + line);
            }

        }

        return driverList;
    }

    private void processDriverLine(final String input, final List<Driver> driverList) {
        final String[] tokens = input.split(" ");
        final String driverName = tokens[1];

        if (driverName != null && driverList.stream().noneMatch(d -> driverName.equalsIgnoreCase(d.getName()))) {
            driverList.add(new Driver(driverName));
        } else {
            System.out.println("Duplicate or invalid driver input: " + input);
        }
    }

    private void processTripLine(final String input, final List<Driver> driverList) {
        final String[] tokens = input.split(" ");
        final String driverName = tokens[1];
        final LocalTime start = LocalTime.parse(tokens[2]);
        final LocalTime end = LocalTime.parse(tokens[3]);
        final float milesDriven = Float.parseFloat(tokens[4]);
        final Trip trip = new Trip(start, end, milesDriven);

        final Optional<Driver> optionalDriver = driverList
                .stream()
                .filter(d -> d.getName().equalsIgnoreCase(driverName)).findFirst();

        if (optionalDriver.isPresent()) {
            optionalDriver.get().addTrip(trip);
        } else {
            final Driver driver = new Driver(driverName);
            driver.addTrip(trip);

            driverList.add(driver);
        }
    }
}
