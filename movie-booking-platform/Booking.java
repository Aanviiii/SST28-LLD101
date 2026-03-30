import java.util.*;

class Booking {
    private String bookingId;
    private User user;
    private Show show;
    private List<ShowSeat> seats;
    private double amount;
    private BookingStatus status;

    public Booking(User user, Show show, List<ShowSeat> seats, double amount) {
        this.bookingId = UUID.randomUUID().toString();
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.amount = amount;
        this.status = BookingStatus.CREATED;
    }

    public void confirm() {
        this.status = BookingStatus.CONFIRMED;
        seats.forEach(s -> s.setStatus(SeatStatus.BOOKED));
    }

    public void cancel() {
        this.status = BookingStatus.CANCELLED;
        seats.forEach(s -> s.setStatus(SeatStatus.AVAILABLE));
    }

    public double getAmount() {
        return amount;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }
}