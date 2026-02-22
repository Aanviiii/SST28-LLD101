import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        RoomTypes roomPolicy = RoomPricing.get(req.roomType);

        Money total = roomPolicy.basePrice();
        for (AddOn addOn : req.addOns) {
            AddOnTypes policy = AddOnPricing.get(addOn);

            total = total.plus(policy.addOnPrice());
        }

        return total;
    }
}
