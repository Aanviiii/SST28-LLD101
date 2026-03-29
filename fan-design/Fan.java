public class Fan {
    private State state;
    private Speed speed;

    Fan() {
        state = State.OFF;
        speed = Speed.LOW; // default when turned ON later
    }

    public void turnOn() {
        state = State.ON;
    }

    public void turnOff() {
        state = State.OFF;
    }

    public void changeSpeed(Speed s) {
        if (state == State.OFF) {
            System.out.println("Fan is OFF. Cannot change speed.");
            return;
        }
        speed = s;
    }

    public Speed getSpeed() {
        return speed;
    }

    public State getState() {
        return state;
    }
}

enum State {
    ON, OFF;
}

enum Speed {
    LOW, MEDIUM, HIGH;
}