package distributedCache;

public class DistributedCacheApplication implements Application {

    private LoadBalancer loadBalancer;

    public DistributedCacheApplication(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @Override
    public String fetch(String key) {
        return loadBalancer.fetch(key);
    }

    public void store(String key, String value) {
        loadBalancer.store(key, value);
    }
}