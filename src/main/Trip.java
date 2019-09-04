import java.time.LocalTime;

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
}
