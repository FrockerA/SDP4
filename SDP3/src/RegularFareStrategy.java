// Regular fare strategy: $1.00 per km and $0.25 per minute
public class RegularFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distanceKm, double durationMin) {
        return Math.max(5.0, distanceKm * 1.00 + durationMin * 0.25); // Minimum fare is $5.0
    }
}

