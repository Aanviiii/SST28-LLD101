class ShowSeat {
    private Seat seat;
    private SeatType type;
    private double price;
    private SeatStatus status;

    public ShowSeat(Seat seat, SeatType type, double price) {
        this.seat = seat;
        this.type = type;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}