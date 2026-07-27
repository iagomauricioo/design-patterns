import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class CalculateFare {

    public static double calculateFare(List<Segment> segments) {
        double fare = 0;

        for (Segment segment : segments) {
            if (!isValidDistance(segment.getDistance())) {
                throw new IllegalArgumentException("Invalid distance");
            }

            if (!isValidDate(segment.getDate())) {
                throw new IllegalArgumentException("Invalid date");
            }

            if (isOvernight(segment.getDate()) && !isSunday(segment.getDate())) {
                fare += segment.getDistance() * 3.90;
            }

            if (isOvernight(segment.getDate()) && isSunday(segment.getDate())) {
                fare += segment.getDistance() * 5.00;
            }

            if (!isOvernight(segment.getDate()) && isSunday(segment.getDate())) {
                fare += segment.getDistance() * 2.90;
            }

            if (!isOvernight(segment.getDate()) && !isSunday(segment.getDate())) {
                fare += segment.getDistance() * 2.10;
            }
        }

        return fare < 10 ? 10 : fare;
    }

    private static boolean isValidDistance(Double distance) {
        return distance != null && distance > 0;
    }

    private static boolean isValidDate(LocalDateTime date) {
        return date != null;
    }

    private static boolean isOvernight(LocalDateTime date) {
        int hour = date.getHour();
        return hour >= 22 || hour <= 6;
    }

    private static boolean isSunday(LocalDateTime date) {
        return date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}