import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripDataServiceImpl implements TripDataService {

    public TripDataServiceImpl() {}

    public List<String> buildFromFile(final String filename) throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line;
        final List<String> tripData = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            tripData.add(line);
        }

        return tripData;
    }
}
