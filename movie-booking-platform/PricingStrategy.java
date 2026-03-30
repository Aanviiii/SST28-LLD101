import java.util.*;

interface PricingStrategy {
    double calculatePrice(List<ShowSeat> seats);
}