package distributedCache;

public class HashDistributionStrategy implements DataDistributionStrategy {

    @Override
    public int getNodeIndex(String key, int totalNodes) {
        return Math.abs(key.hashCode()) % totalNodes;
    }
}
