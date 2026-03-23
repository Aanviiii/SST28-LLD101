public abstract class ParkingSlot {
    protected int slotId;
    protected SlotType slotType;
    protected boolean isAvailable;

    public ParkingSlot(int slotId, SlotType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void park() {
        isAvailable = false;
    }

    public void free() {
        isAvailable = true;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public int getSlotId() {
        return slotId;
    }
}