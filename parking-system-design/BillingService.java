import java.util.Map;

public class BillingService {

    private Map<SlotType, Integer> rates;

    public BillingService(Map<SlotType, Integer> rates) {
        this.rates = rates;
    }

    public double calculateBill(ParkingTicket ticket, long exitTime) {
        long duration = exitTime - ticket.getEntryTime();

        long hours = (long) Math.ceil(duration / 3600.0);

        SlotType slotType = ticket.getSlot().getSlotType();

        return hours * rates.get(slotType);
    }
}