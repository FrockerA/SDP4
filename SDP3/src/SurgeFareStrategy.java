// Surge fare strategy: Double the Regular fare
public class SurgeFareStrategy implements FareStrategy {
    @Override
    public double calculateFare(double distanceKm, double durationMin) {
        return Math.max(8.0, 2 * (distanceKm * 1.00 + durationMin * 0.25)); // Minimum fare is $8.0
    }
}