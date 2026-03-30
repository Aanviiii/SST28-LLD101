import java.util.*;

interface SeatLockProvider {
    boolean lockSeats(String showId, List<String> seatIds);

    void unlockSeats(String showId, List<String> seatIds);
}