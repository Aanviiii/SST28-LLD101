import java.util.*;

class FCFSSchedulingStrategy implements SchedulingStrategy {
    public List<Integer> schedule(List<Integer> stops, Request request) {
        stops.add(request.sourceFloor);
        stops.add(request.destinationFloor);
        return stops;
    }
}