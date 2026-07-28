import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FareCalculatorTest {

    private FareCalculator normalCalculator;
    private FareCalculator overnightCalculator;
    private FareCalculator sundayCalculator;
    private FareCalculator overnightSundayCalculator;

    @BeforeEach
    void setUp() {
        normalCalculator = new NormalFareCalculator();
        overnightCalculator = new OvernightFareCalculator();
        sundayCalculator = new SundayFareCalculator();
        overnightSundayCalculator = new OvernightSundayFareCalculator();
    }

    @Test
    void shouldCalculateDuringNormalHours() {
        double fare = normalCalculator.calculate(
                new Segment(10.0, LocalDateTime.of(2021, 3, 1, 10, 0))
        );

        assertEquals(21.0, fare);
    }

    @Test
    void shouldCalculateDuringNight() {
        double fare = overnightCalculator.calculate(
                new Segment(10.0, LocalDateTime.of(2021, 3, 1, 23, 0))
        );

        assertEquals(39.0, fare);
    }

    @Test
    void shouldCalculateDuringSunday() {
        double fare = sundayCalculator.calculate(
                new Segment(10.0, LocalDateTime.of(2021, 3, 7, 10, 0)
        ));
        // esse dia é um domingo

        assertEquals(29.0, fare);
    }

    @Test
    void shouldCalculateDuringSundayNight() {
        double fare = overnightSundayCalculator.calculate(
                new Segment(10.0, LocalDateTime.of(2021, 3, 7, 23, 0))
        );
        // esse dia é um domingo

        assertEquals(50.0, fare);
    }

    @Test
    void shouldCalculateMininumFare() {
        Ride ride = new Ride(normalCalculator);
        ride.addSegment(2.0, LocalDateTime.of(2021, 3, 1, 10, 0));
        ride.calculateFare();
        assertEquals(10.0, ride.getFare());
    }

    @Test
    void shouldNotCalculateInvalidDistance() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Segment(null, LocalDateTime.of(2021, 3, 1, 23, 0))
        );

        assertEquals("Invalid distance", exception.getMessage());
    }
}