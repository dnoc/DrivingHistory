import java.io.IOException;
import java.util.List;

interface TripDataService {
    List<Driver> buildFromFile(final String filename) throws IOException;
}

