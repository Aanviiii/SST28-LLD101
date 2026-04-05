package rateLimiter;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter() {
        int limit = 5;
        long window = 10000; // 10 seconds
        return new FixedWindowRL(limit, window);
    }
}