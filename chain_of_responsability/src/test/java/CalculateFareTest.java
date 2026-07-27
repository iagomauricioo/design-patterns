import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateFareTest {

    @Test
    void shouldCalculateFareDuringNormalHours() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(10.0, LocalDateTime.of(2021, 3, 1, 10, 0)));

        double fare = CalculateFare.calculateFare(segments);

        assertEquals(21.0, fare);
    }

    @Test
    void shouldCalculateFareDuringNight() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(10.0, LocalDateTime.of(2021, 3, 1, 23, 0)));

        double fare = CalculateFare.calculateFare(segments);

        assertEquals(39.0, fare);
    }

    @Test
    void shouldCalculateFareDuringSunday() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(10.0, LocalDateTime.of(2021, 3, 7, 10, 0)));
        // esse dia é um domingo

        double fare = CalculateFare.calculateFare(segments);

        assertEquals(29.0, fare);
    }

    @Test
    void shouldCalculateFareDuringSundayNight() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(10.0, LocalDateTime.of(2021, 3, 7, 23, 0)));
        // esse dia é um domingo

        double fare = CalculateFare.calculateFare(segments);

        assertEquals(50.0, fare);
    }

    @Test
    void shouldCalculateMininumFare() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(2.0, LocalDateTime.of(2021, 3, 1, 23, 0)));

        double fare = CalculateFare.calculateFare(segments);

        assertEquals(10.0, fare);
    }

    @Test
    void shouldNotCalculateInvalidDistance() {
        List<Segment> segments = new ArrayList<>();
        segments.add(new Segment(null, LocalDateTime.of(2021, 3, 1, 23, 0)));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> CalculateFare.calculateFare(segments)
        );

        assertEquals("Invalid distance", exception.getMessage());
    }
}