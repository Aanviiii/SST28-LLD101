public class Vehicle {
    private String id;
    private VehicleType type;

    public Vehicle(String id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    public VehicleType getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}