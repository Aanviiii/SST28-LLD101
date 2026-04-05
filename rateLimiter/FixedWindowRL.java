package rateLimiter;

import java.util.*;

public class FixedWindowRL implements RateLimiter {
    private final int limit;
    private final long windowSizeInMillis;

    private Map<String, Integer> requestCount;
    private Map<String, Long> windowStartTime;

    public FixedWindowRL(int limit, long windowSizeInMillis) {
        this.limit = limit;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestCount = new HashMap<>();
        this.windowStartTime = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();

        windowStartTime.putIfAbsent(userId, currentTime);
        requestCount.putIfAbsent(userId, 0);

        long startTime = windowStartTime.get(userId);

        // If window expired → reset
        if (currentTime - startTime >= windowSizeInMillis) {
            windowStartTime.put(userId, currentTime);
            requestCount.put(userId, 0);
        }

        int currentCount = requestCount.get(userId);

        if (currentCount < limit) {
            requestCount.put(userId, currentCount + 1);
            return true;
        }

        return false;
    }
}