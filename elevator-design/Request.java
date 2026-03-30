class Request {
    int sourceFloor;
    int destinationFloor;
    Direction direction;

    public Request(int source, int destination) {
        this.sourceFloor = source;
        this.destinationFloor = destination;
        this.direction = (destination > source) ? Direction.UP : Direction.DOWN;
    }
}