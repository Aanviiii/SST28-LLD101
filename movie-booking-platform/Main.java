import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Setup
        Seat s1 = new Seat("A1", 1, 1);
        Seat s2 = new Seat("A2", 1, 2);

        Screen screen = new Screen();
        screen.seats = List.of(s1, s2);

        Movie movie = new Movie("M1", "Inception");
        Show show = new Show("S1", movie, screen);

        // Create show seats (dynamic)
        show.showSeats.put("A1", new ShowSeat(s1, SeatType.GOLD, 200));
        show.showSeats.put("A2", new ShowSeat(s2, SeatType.PLATINUM, 300));

        User user = new User("U1", "Aanvi");

        // Dependencies
        SeatLockProvider lockProvider = new InMemorySeatLockProvider();
        PricingStrategy pricing = new DefaultPricingStrategy();

        BookingService bookingService = new BookingService(lockProvider, pricing);
        PaymentService paymentService = new PaymentService();

        // Select seats
        List<ShowSeat> selectedSeats = List.of(
                show.showSeats.get("A1"),
                show.showSeats.get("A2"));

        // Booking flow
        Booking booking = bookingService.createBooking(user, show, selectedSeats);

        // Payment
        PaymentStrategy payment = new UPIPayment();
        paymentService.processPayment(booking, payment);

        System.out.println("Booking Confirmed!");
    }
}