import java.util.*;

public class ParkingLot {

    private List<ParkingSlot> slots;
    private BillingService billingService;

    public ParkingLot(List<ParkingSlot> slots, BillingService billingService) {
        this.slots = slots;
        this.billingService = billingService;
    }

    public ParkingTicket park(Vehicle vehicle, long entryTime, SlotType requestedType, int gateId) {

        ParkingSlot slot = findSlot(vehicle, requestedType);

        if (slot == null) {
            throw new RuntimeException("No slot available");
        }

        slot.park();

        return new ParkingTicket(vehicle, slot, entryTime);
    }

    private ParkingSlot findSlot(Vehicle vehicle, SlotType requestedType) {

        for (ParkingSlot slot : slots) {
            if (slot.isAvailable() &&
                    isCompatible(vehicle, slot) &&
                    isAllowedByRequest(slot, requestedType)) {
                return slot;
            }
        }
        return null;
    }

    private boolean isCompatible(Vehicle vehicle, ParkingSlot slot) {
        VehicleType v = vehicle.getType();
        SlotType s = slot.getSlotType();

        if (v == VehicleType.BIKE)
            return true;
        if (v == VehicleType.CAR)
            return s == SlotType.MEDIUM || s == SlotType.LARGE;
        if (v == VehicleType.BUS)
            return s == SlotType.LARGE;

        return false;
    }

    private boolean isAllowedByRequest(ParkingSlot slot, SlotType requestedType) {
        // Optional filter (can ignore if not needed)
        return requestedType == null || slot.getSlotType() == requestedType;
    }

    public double exit(ParkingTicket ticket, long exitTime) {
        ticket.getSlot().free();
        return billingService.calculateBill(ticket, exitTime);
    }

    public Map<SlotType, Integer> status() {
        Map<SlotType, Integer> map = new HashMap<>();

        for (ParkingSlot slot : slots) {
            if (slot.isAvailable()) {
                map.put(slot.getSlotType(),
                        map.getOrDefault(slot.getSlotType(), 0) + 1);
            }
        }
        return map;
    }
}