import java.util.*;

public class AddOnPricing {

    private static final Map<AddOn, AddOnTypes> policies = new HashMap<>();

    static {
        policies.put(AddOn.MESS, new MessAddOn());
        policies.put(AddOn.LAUNDRY, new LaundryAddOn());
        policies.put(AddOn.GYM, new GymAddOn());
    }

    public static AddOnTypes get(AddOn addOn) {
        return policies.get(addOn);
    }
}