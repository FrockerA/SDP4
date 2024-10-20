// Premium fare strategy: $1.50 per km and $0.40 per minute
public class PremiumFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distanceKm, double durationMin) {
        return Math.max(10.0, distanceKm * 1.50 + durationMin * 0.40); // Minimum fare is $10.0
    }
}