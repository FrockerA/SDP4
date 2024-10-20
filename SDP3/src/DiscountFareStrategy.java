// Discount fare strategy: $0.80 per km and $0.20 per minute
public class DiscountFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distanceKm, double durationMin) {
        return Math.max(4.0, distanceKm * 0.80 + durationMin * 0.20); // Minimum fare is $4.0
    }
}