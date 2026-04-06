package distributedCache;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Database db = new InMemoryDatabase();
        RetrievalAdapter adapter = new DatabaseRetrievalAdapter(db);

        EvictionStrategy lru1 = new LRUStrategy();
        EvictionStrategy lru2 = new LRUStrategy();

        Cache cache1 = new Cache(2, lru1, adapter);
        Cache cache2 = new Cache(2, lru2, adapter);

        List<Cache> nodes = Arrays.asList(cache1, cache2);

        DataDistributionStrategy strategy = new HashDistributionStrategy();

        LoadBalancer lb = new LoadBalancer(nodes, strategy);

        DistributedCacheApplication app = new DistributedCacheApplication(lb);

        app.store("A", "Apple");
        app.store("B", "Ball");

        System.out.println(app.fetch("A"));
        System.out.println(app.fetch("B"));
        System.out.println(app.fetch("C")); // triggers DB fetch
    }
}