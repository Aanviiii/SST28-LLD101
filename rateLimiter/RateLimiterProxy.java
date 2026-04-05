package rateLimiter;

public class RateLimiterProxy implements Service {
    private final RateLimiter rateLimiter;
    private final Service service;

    public RateLimiterProxy(RateLimiter rateLimiter, Service service) {
        this.rateLimiter = rateLimiter;
        this.service = service;
    }

    @Override
    public void handleRequest(String userId) {
        if (rateLimiter.allowRequest(userId)) {
            service.handleRequest(userId);
        } else {
            System.out.println("Rate limit exceeded for user: " + userId);
        }
    }
}