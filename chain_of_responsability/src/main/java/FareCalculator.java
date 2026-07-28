public interface FareCalculator {
    void setNext(FareCalculator next);
    FareCalculator getNext();
    double calculate(Segment segment);
}
