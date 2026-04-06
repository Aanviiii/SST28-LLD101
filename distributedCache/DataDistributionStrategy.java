package distributedCache;

public interface DataDistributionStrategy {
    int getNodeIndex(String key, int totalNodes);
}
