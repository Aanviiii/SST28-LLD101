package distributedCache;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private int maxCapacity;
    private Map<String, String> cacheMap;
    private EvictionStrategy evictionStrategy;
    private RetrievalAdapter retrievalAdapter;

    public Cache(int maxCapacity,
            EvictionStrategy evictionStrategy,
            RetrievalAdapter retrievalAdapter) {
        this.maxCapacity = maxCapacity;
        this.cacheMap = new HashMap<>();
        this.evictionStrategy = evictionStrategy;
        this.retrievalAdapter = retrievalAdapter;
    }

    public String get(String key) {
        if (cacheMap.containsKey(key)) {
            evictionStrategy.keyAccessed(key);
            return cacheMap.get(key);
        }

        // Fetch from DB via adapter
        String value = retrievalAdapter.retrieve(key);
        if (value != null) {
            put(key, value);
        }
        return value;
    }

    public void put(String key, String value) {
        if (cacheMap.size() >= maxCapacity) {
            String evictKey = evictionStrategy.evictKey();
            cacheMap.remove(evictKey);
        }

        cacheMap.put(key, value);
        evictionStrategy.keyAccessed(key);
    }

    public void remove(String key) {
        cacheMap.remove(key);
    }
}