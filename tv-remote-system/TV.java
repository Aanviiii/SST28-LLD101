public class TV {
    private int volume;
    private int channel;
    private TVState state;

    TV() {
        this.volume = 50;
        this.channel = 1;
        this.state = TVState.OFF;
    }

    public void turnOn() {
        state = TVState.ON;
    }

    public void turnOff() {
        state = TVState.OFF;
    }

    public void increaseVolume() {
        if (state == TVState.OFF)
            return;

        if (volume < 100) {
            volume++;
        }
    }

    public void decreaseVolume() {
        if (state == TVState.OFF)
            return;

        if (volume > 0) {
            volume--;
        }
    }

    public void setChannel(int c) {
        if (state == TVState.OFF) {
            System.out.println("TV is OFF");
            return;
        }

        if (c > 0) {
            channel = c;
        }
    }

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public TVState getState() {
        return state;
    }
}

enum TVState {
    ON, OFF;
}

class Remote {
    private TV tv;

    Remote(TV tv) {
        this.tv = tv;
    }

    public void turnOn() {
        tv.turnOn();
    }

    public void turnOff() {
        tv.turnOff();
    }

    public void volumeUp() {
        tv.increaseVolume();
    }

    public void volumeDown() {
        tv.decreaseVolume();
    }

    public void changeChannel(int c) {
        tv.setChannel(c);
    }
}