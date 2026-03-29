import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;

    ParkingLot(List<ParkingSpot> spots) {
        this.spots = spots;
    }

    public void assignSpot(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (!spot.isOccupied()) {
                spot.assignVehicle(v);
                System.out.println("Vehicle parked");
                return; // ✅ stop after assigning
            }
        }
        System.out.println("Parking Full");
    }

    public void freeSpot(Vehicle v) {
        for (ParkingSpot spot : spots) {
            if (spot.getVehicle() == v) {
                spot.removeVehicle();
                System.out.println("Vehicle removed");
                return; // ✅ stop after removing
            }
        }
        System.out.println("Vehicle not found");
    }
}

class Vehicle {
    int no;
    String type;

    Vehicle(int no, String type) {
        this.no = no;
        this.type = type;
    }
}

class ParkingSpot {
    private Vehicle vehicle;
    private boolean isOccupied;

    ParkingSpot() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void assignVehicle(Vehicle v) {
        this.vehicle = v;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}