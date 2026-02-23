import java.util.*;

public class EligibilityEngine {

    private final List<EligibilityRule> rules;
    private final EligibilityStore store;

    public EligibilityEngine(List<EligibilityRule> rules,
            EligibilityStore store) {
        this.rules = rules;
        this.store = store;
    }

    public void runAndPrint(StudentProfile s) {

        ReportPrinter printer = new ReportPrinter();

        EligibilityEngineResult result = evaluate(s);

        printer.print(s, result);

        store.save(s.rollNo, result.status);
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {

        List<String> reasons = new ArrayList<>();

        for (EligibilityRule rule : rules) {
            String reason = rule.check(s);

            if (reason != null) {
                reasons.add(reason);
                break; // preserve original else-if behavior
            }
        }

        String status = reasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";

        return new EligibilityEngineResult(status, reasons);
    }
}