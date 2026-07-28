public class SundayFareCalculator implements FareCalculator {

    private FareCalculator next;

    @Override
    public void setNext(FareCalculator next) {
        this.next = next;
    }

    @Override
    public FareCalculator getNext() {
        return this.next;
    }

    @Override
    public double calculate(Segment segment) {
        double FARE = 2.9;

        if (!segment.isOvernight() && segment.isSunday()) {
            return segment.getDistance() * FARE;
        }
        if (next != null) {
            return next.calculate(segment);
        }

        throw new IllegalArgumentException("Calculator not free");
    }
}