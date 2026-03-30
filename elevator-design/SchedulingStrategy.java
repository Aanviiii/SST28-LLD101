import java.util.List;

interface SchedulingStrategy {
    List<Integer> schedule(List<Integer> currentStops, Request request);
}