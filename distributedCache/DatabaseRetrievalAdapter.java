package distributedCache;

public class DatabaseRetrievalAdapter implements RetrievalAdapter {

    private Database database;

    public DatabaseRetrievalAdapter(Database database) {
        this.database = database;
    }

    @Override
    public String retrieve(String key) {
        return database.get(key);
    }

    @Override
    public void store(String key, String value) {
        database.put(key, value);
    }
}