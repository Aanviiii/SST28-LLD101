package distributedCache;

public interface EvictionStrategy {
    void keyAccessed(String key);

    String evictKey();
}