import java.util.*;
import java.util.stream.Collectors;

public class BookingService {

    private SeatLockProvider seatLockProvider;
    private PricingStrategy pricingStrategy;

    public BookingService(SeatLockProvider seatLockProvider,
            PricingStrategy pricingStrategy) {
        this.seatLockProvider = seatLockProvider;
        this.pricingStrategy = pricingStrategy;
    }

    public Booking createBooking(User user, Show show, List<ShowSeat> seats) {

        List<String> seatIds = seats.stream()
                .map(s -> s.getSeat().getSeatId())
                .collect(Collectors.toList());

        boolean locked = seatLockProvider.lockSeats(show.getShowId(), seatIds);

        if (!locked) {
            throw new RuntimeException("Seats already locked");
        }

        double amount = pricingStrategy.calculatePrice(seats);

        return new Booking(user, show, seats, amount);
    }
}