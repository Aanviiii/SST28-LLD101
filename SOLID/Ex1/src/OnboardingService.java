import java.util.*;

public class OnboardingService {
    private final StudentRepo repo;
    private final ParseInput parse;
    private final Validator valid;
    private final Printer printer;

    public OnboardingService(StudentRepo repo, ParseInput parse, Validator valid, Printer printer) {
        this.repo = repo;
        this.parse = parse;
        this.valid = valid;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> parsedData = parse.parser(raw);
        List<String> errors = valid.validate(parsedData);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, parsedData.get("name"), parsedData.get("email"),
                parsedData.get("phone"), parsedData.get("program"));

        repo.save(rec);
        printer.printCreation(rec, repo.count());
    }
}
