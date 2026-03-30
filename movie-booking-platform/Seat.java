class Seat {
    String seatId;
    int row;
    int col;

    public Seat(String seatId, int row, int col) {
        this.seatId = seatId;
        this.row = row;
        this.col = col;
    }

    public String getSeatId() {
        return seatId;
    }
}