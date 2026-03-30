import java.util.*;

public class Main {
    public static void main(String[] args) {

        SchedulingStrategy fcfs = new FCFSSchedulingStrategy();

        Elevator e1 = new Elevator(1, 750, fcfs);
        Elevator e2 = new Elevator(2, 750, fcfs);

        List<Elevator> elevators = Arrays.asList(e1, e2);

        ElevatorSelectionStrategy selectionStrategy = new NearestElevatorStrategy();

        ElevatorController controller = new ElevatorController(elevators, selectionStrategy);

        controller.handleRequest(new Request(2, 8));
        controller.handleRequest(new Request(3, 1));

        controller.step();
        controller.step();
    }
}