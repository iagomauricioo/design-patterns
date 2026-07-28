import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Segment {

    private final Double distance;
    private final LocalDateTime date;

    public Segment(Double distance, LocalDateTime date) {
        this.distance = distance;
        this.date = date;

        if (!isValidDistance()) {
            throw new IllegalArgumentException("Invalid distance");
        }

        if (!isValidDate()) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    public Double getDistance() {
        return distance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isValidDistance() {
        return this.distance != null && this.distance > 0;
    }

    public boolean isValidDate() {
        return this.date != null;
    }

    public boolean isOvernight() {
        int hour = this.date.getHour();
        return hour >= 22 || hour <= 6;
    }

    public boolean isSunday() {
        return this.date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}