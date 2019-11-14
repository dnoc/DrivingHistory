import java.io.IOException;
import java.util.List;

interface TripFileService {
    List<Driver> buildFromFile(final String filename) throws IOException;
}

