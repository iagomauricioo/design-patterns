import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ride {

    private final List<Segment> segments;
    private final FareCalculator fareCalculator;
    private double fare;

    public Ride(FareCalculator fareCalculator) {
        this.fareCalculator = fareCalculator;
        this.segments = new ArrayList<>();
        this.fare = 0;
    }

    public void addSegment(Double distance, LocalDateTime date) {
        this.segments.add(new Segment(distance, date));
    }

    public void calculateFare() {
        this.fare = 0;
        for (Segment segment : this.segments) {
            this.fare += this.fareCalculator.calculate(segment);
        }
        this.fare = (this.fare < 10) ? 10 : this.fare;
    }

    public double getFare() {
        return this.fare;
    }
}
