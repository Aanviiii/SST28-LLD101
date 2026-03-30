import java.util.*;

class NearestElevatorStrategy implements ElevatorSelectionStrategy {

    public Elevator selectElevator(List<Elevator> elevators, Request request) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int distance = Math.abs(e.getCurrentFloor() - request.sourceFloor);

            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }

        return best;
    }
}