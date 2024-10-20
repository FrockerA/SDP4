// RideTest.java
import java.time.LocalTime;

public class RideTest {
    public static void main(String[] args) {
        RideContext rideContext = new RideContext();

        // Test different rides
        testRide(rideContext, 3, 10, LocalTime.of(8, 30)); // Peak hour (Surge)
        testRide(rideContext, 15, 30, LocalTime.of(14, 0)); // Regular
        testRide(rideContext, 25, 50, LocalTime.of(14, 0)); // Long distance (Premium)
        testRide(rideContext, 4, 12, LocalTime.of(20, 0)); // Short ride (Discount)
    }

    private static void testRide(RideContext context, double distanceKm, double durationMin, LocalTime time) {
        context.selectStrategy(distanceKm, time);
        double fare = context.calculateFare(distanceKm, durationMin);
        System.out.printf("Ride with Distance = %.2f km, Duration = %.2f min at %s -> Fare: $%.2f%n",
                distanceKm, durationMin, time, fare);
    }
}
