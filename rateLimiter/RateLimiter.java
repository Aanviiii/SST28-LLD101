package rateLimiter;

interface RateLimiter {
    boolean allowRequest(String userId);
}
