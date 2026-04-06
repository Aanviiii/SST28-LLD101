package distributedCache;

public interface Database {
    void put(String key, String value);

    String get(String key);
}
