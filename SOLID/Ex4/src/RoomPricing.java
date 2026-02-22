import java.util.HashMap;
import java.util.Map;

public class RoomPricing {

    private static final Map<Integer, RoomTypes> policies = new HashMap<>();

    static {
        policies.put(LegacyRoomTypes.SINGLE, new SingleRoomType());
        policies.put(LegacyRoomTypes.DOUBLE, new DoubleRoomType());
        policies.put(LegacyRoomTypes.TRIPLE, new TripleRoomType());
        policies.put(LegacyRoomTypes.DELUXE, new DoubleRoomType());
    }

    public static RoomTypes get(int roomType) {
        return policies.get(roomType);
    }
}