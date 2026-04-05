package rateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter();
        Service realService = new RealService();
        Service proxy = new RateLimiterProxy(rateLimiter, realService);

        String user = "user1";

        // Simulate requests
        for (int i = 1; i <= 10; i++) {
            proxy.handleRequest(user);
            Thread.sleep(1000); // 1 sec gap
        }
    }
}