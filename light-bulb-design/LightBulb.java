public class LightBulb {
    private State state;

    LightBulb() {
        state = State.OFF;
    }

    public void turnOn() {
        state = State.ON;
    }

    public void turnOff() {
        state = State.OFF;
    }

    public State getState() {
        return state;
    }
}

enum State {
    ON, OFF;
}