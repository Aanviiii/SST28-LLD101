public class CgrRule implements EligibilityRule {
    private final double minCgr;

    public CgrRule(double minCgr) {
        this.minCgr = minCgr;
    }

    public String check(StudentProfile s) {
        if (s.cgr < minCgr) {
            return "CGR below " + minCgr;
        }
        return null;
    }
}