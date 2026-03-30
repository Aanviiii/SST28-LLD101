import java.util.*;

public class DefaultPricingStrategy implements PricingStrategy {
    public double calculatePrice(List<ShowSeat> seats) {
        return seats.stream().mapToDouble(ShowSeat::getPrice).sum();
    }
}