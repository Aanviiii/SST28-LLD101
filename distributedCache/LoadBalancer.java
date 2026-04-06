package distributedCache;

import java.util.List;

public class LoadBalancer {

    private List<Cache> cacheNodes;
    private DataDistributionStrategy strategy;

    public LoadBalancer(List<Cache> cacheNodes,
            DataDistributionStrategy strategy) {
        this.cacheNodes = cacheNodes;
        this.strategy = strategy;
    }

    public void store(String key, String value) {
        int index = strategy.getNodeIndex(key, cacheNodes.size());
        cacheNodes.get(index).put(key, value);
    }

    public String fetch(String key) {
        int index = strategy.getNodeIndex(key, cacheNodes.size());
        return cacheNodes.get(index).get(key);
    }
}