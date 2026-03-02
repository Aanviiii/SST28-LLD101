import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

/**
 * Starter demo that shows why mutability is risky.
 *
 * After refactor:
 * - direct mutation should not compile (no setters)
 * - external modifications to tags should not affect the ticket
 * - service "updates" should return a NEW ticket instance
 */
public class TryIt {

    public static void main(String[] args) {

        TicketService service = new TicketService();

        IncidentTicket t = service.createTicket(
                "TCK-1001",
                "reporter@example.com",
                "Payment failing on checkout");

        System.out.println("Created:");
        System.out.println(t);

        t = service.assign(t, "agent@example.com");
        t = service.escalateToCritical(t);

        System.out.println("\nAfter updates (new instances created):");
        System.out.println(t);

        System.out.println("\nAttempting external tag modification...");

        List<String> tags = t.getTags();

        try {
            tags.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify tags from outside! Ticket is immutable.");
        }

        System.out.println("\nFinal ticket state:");
        System.out.println(t);

        IncidentTicket original = service.createTicket(
                "TCK-2001",
                "reporter2@example.com",
                "Login issue");

        IncidentTicket updated = service.assign(original, "agent2@example.com");

        System.out.println("\nOriginal ticket:");
        System.out.println(original);

        System.out.println("\nUpdated ticket (different instance):");
        System.out.println(updated);

        System.out.println("\nAre original and updated same object? "
                + (original == updated));
    }
}