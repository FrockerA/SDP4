// RideContext.java
import java.time.LocalTime;

public class RideContext {
    private FareStrategy strategy;

    public RideContext() {
        this.strategy = new RegularFareStrategy();
    }

    public void setStrategy(FareStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateFare(double distanceKm, double durationMin) {
        if (distanceKm < 0 || durationMin < 0) {
            throw new IllegalArgumentException("Distance and duration must be non-negative.");
        }
        return strategy.calculateFare(distanceKm, durationMin);
    }

    public void selectStrategy(double distanceKm, LocalTime time) {
        if (isPeakHour(time)) {
            setStrategy(new SurgeFareStrategy()); // Surge pricing during peak hours
        } else if (distanceKm > 20) {
            setStrategy(new PremiumFareStrategy()); // Long distance ride
        } else if (distanceKm < 5) {
            setStrategy(new DiscountFareStrategy()); // Short distance ride
        } else {
            setStrategy(new RegularFareStrategy()); // Default to regular fare
        }
    }

    private boolean isPeakHour(LocalTime time) {
        return (time.isAfter(LocalTime.of(7, 0)) && time.isBefore(LocalTime.of(9, 0))) ||
                (time.isAfter(LocalTime.of(17, 0)) && time.isBefore(LocalTime.of(19, 0)));
    }
}
