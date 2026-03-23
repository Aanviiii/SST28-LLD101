import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer, Integer> jumps;

    public Board(int size) {
        this.size = size;
        this.jumps = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void addJump(int start, int end) {
        jumps.put(start, end);
    }

    public int resolvePosition(int position) {
        return jumps.getOrDefault(position, position);
    }
}