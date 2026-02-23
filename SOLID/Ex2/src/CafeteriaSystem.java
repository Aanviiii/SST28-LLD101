import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private int invoiceSeq = 1000;

    public CafeteriaSystem() {
        this.store = new FileStore(); // persistence abstraction
        this.taxPolicy = new TaxRules(); // tax logic abstraction
        this.discountPolicy = new DiscountRules(); // discount abstraction
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        // Pricing responsibility
        PricingService pricing = new PricingService(menu);

        double subtotal = pricing.subtotal(lines);
        List<String> lineDescriptions = pricing.lineDescriptions(lines);

        // Tax calculation
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        // Discount calculation
        double discount = discountPolicy.discount(
                customerType,
                subtotal,
                lines.size());

        double total = subtotal + tax - discount;

        // Formatting responsibility
        InvoicePrinter printer = new InvoicePrinter();

        String printable = printer.format(
                invId,
                lineDescriptions,
                subtotal,
                taxPct,
                tax,
                discount,
                total);

        // Output
        System.out.print(printable);

        // Persistence responsibility
        store.save(invId, printable);

        System.out.println(
                "Saved invoice: " + invId +
                        " (lines=" + store.countLines(invId) + ")");
    }
}