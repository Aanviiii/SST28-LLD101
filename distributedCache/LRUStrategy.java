package distributedCache;

import java.util.*;

public class LRUStrategy implements EvictionStrategy {

    private LinkedHashSet<String> set = new LinkedHashSet<>();

    @Override
    public void keyAccessed(String key) {
        set.remove(key);
        set.add(key);
    }

    @Override
    public String evictKey() {
        Iterator<String> it = set.iterator();
        String oldest = it.next();
        it.remove();
        return oldest;
    }
}