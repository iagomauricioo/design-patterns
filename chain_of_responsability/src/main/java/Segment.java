import java.time.LocalDateTime;

public class Segment {

    private final Double distance;
    private final LocalDateTime date;

    public Segment(Double distance, LocalDateTime date) {
        this.distance = distance;
        this.date = date;
    }

    public Double getDistance() {
        return distance;
    }

    public LocalDateTime getDate() {
        return date;
    }
}