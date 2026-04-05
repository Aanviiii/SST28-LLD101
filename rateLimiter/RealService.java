package rateLimiter;

public class RealService implements Service {
    @Override
    public void handleRequest(String userId) {
        System.out.println("Request processed for user: " + userId);
    }
}