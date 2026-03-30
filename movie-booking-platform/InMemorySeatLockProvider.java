import java.util.*;

class InMemorySeatLockProvider implements SeatLockProvider {

    private Map<String, Set<String>> lockedSeats = new HashMap<>();

    @Override
    public synchronized boolean lockSeats(String showId, List<String> seatIds) {
        lockedSeats.putIfAbsent(showId, new HashSet<>());
        Set<String> locked = lockedSeats.get(showId);

        for (String seatId : seatIds) {
            if (locked.contains(seatId))
                return false;
        }

        locked.addAll(seatIds);
        return true;
    }

    @Override
    public synchronized void unlockSeats(String showId, List<String> seatIds) {
        if (lockedSeats.containsKey(showId)) {
            lockedSeats.get(showId).removeAll(seatIds);
        }
    }
}