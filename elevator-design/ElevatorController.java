import java.util.*;

class ElevatorController {
    private List<Elevator> elevators;
    private ElevatorSelectionStrategy selectionStrategy;

    public ElevatorController(List<Elevator> elevators,
            ElevatorSelectionStrategy strategy) {
        this.elevators = elevators;
        this.selectionStrategy = strategy;
    }

    public void setSelectionStrategy(ElevatorSelectionStrategy strategy) {
        this.selectionStrategy = strategy;
    }

    public void handleRequest(Request request) {
        Elevator elevator = selectionStrategy.selectElevator(elevators, request);
        System.out.println("Assigned Elevator: " + elevator.getId());
        elevator.addRequest(request);
    }

    public void step() {
        for (Elevator e : elevators) {
            e.move();
        }
    }
}