import java.util.List;

public interface StudentRepo {
    void save(StudentRecord record);

    int count();

    List<StudentRecord> all();
}