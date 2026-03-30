public class PaymentService {

    public void processPayment(Booking booking, PaymentStrategy strategy) {
        strategy.pay(booking.getAmount());
        booking.confirm();
    }
}