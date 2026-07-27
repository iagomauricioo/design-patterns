import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}