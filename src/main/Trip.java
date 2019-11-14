import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Trip {

    private LocalTime start;
    private LocalTime end;
    private float milesDriven;

    public Trip(final LocalTime start, final LocalTime end, final float milesDriven) {
        this.start = start;
        this.end = end;
        this.milesDriven = milesDriven;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public float getMilesDriven() {
        return milesDriven;
    }

    public float getDurationInHours() {
        return (start.until(end, ChronoUnit.MINUTES) / 60f);
    }

    public float getSpeed() {
        final float duration = start.until(end, ChronoUnit.MINUTES);

        return milesDriven / (duration / 60f);
    }

    public boolean isHighwayTrip() {
        return getSpeed() >= 50;
    }

    public boolean isValidTrip() {
        return getSpeed() <= 100 && getSpeed() >= 5;
    }
}
