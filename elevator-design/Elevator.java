import java.util.*;

class Elevator {
    private int id;
    private int currentFloor;
    private Direction direction;
    private int maxWeight;
    private int currentLoad;

    private SchedulingStrategy schedulingStrategy;
    private List<Integer> stops;

    public Elevator(int id, int maxWeight, SchedulingStrategy strategy) {
        this.id = id;
        this.maxWeight = maxWeight;
        this.schedulingStrategy = strategy;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.stops = new ArrayList<>();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }

    public void setSchedulingStrategy(SchedulingStrategy strategy) {
        this.schedulingStrategy = strategy;
    }

    public void addRequest(Request request) {
        stops = schedulingStrategy.schedule(stops, request);
    }

    public void move() {
        if (stops.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        int nextFloor = stops.remove(0);

        if (nextFloor > currentFloor)
            direction = Direction.UP;
        else if (nextFloor < currentFloor)
            direction = Direction.DOWN;

        currentFloor = nextFloor;

        System.out.println("Elevator " + id + " reached floor " + currentFloor);
    }
}