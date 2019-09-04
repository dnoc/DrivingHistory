import java.io.IOException;
import java.util.List;

interface TripDataService {
    List<String> buildFromFile(final String filename) throws IOException;
}

