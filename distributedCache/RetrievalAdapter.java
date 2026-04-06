package distributedCache;

public interface RetrievalAdapter {
    String retrieve(String key);

    void store(String key, String value);
}
