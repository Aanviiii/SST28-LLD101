import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<ParkingSlot> slots = new ArrayList<>();

        slots.add(new SmallSlot(1));
        slots.add(new MediumSlot(2));
        slots.add(new LargeSlot(3));

        Map<SlotType, Integer> rates = new HashMap<>();
        rates.put(SlotType.SMALL, 10);
        rates.put(SlotType.MEDIUM, 20);
        rates.put(SlotType.LARGE, 30);

        BillingService billingService = new BillingService(rates);

        ParkingLot parkingLot = new ParkingLot(slots, billingService);

        Vehicle car = new Vehicle("KA01", VehicleType.CAR);

        long entryTime = System.currentTimeMillis();

        ParkingTicket ticket = parkingLot.park(car, entryTime, null, 1);

        System.out.println("Parked at slot: " + ticket.getSlot().getSlotId());

        long exitTime = entryTime + (2 * 3600 * 1000); // 2 hours later

        double bill = parkingLot.exit(ticket, exitTime);

        System.out.println("Total bill: " + bill);

        System.out.println("Available slots: " + parkingLot.status());
    }
}