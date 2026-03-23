public class BoardBuilder {

    public static Board buildBoard() {
        int n = 6; // Hardcoded board size (6x6)
        Board board = new Board(n * n);

        // Ladders
        board.addJump(3, 22);
        board.addJump(5, 8);
        board.addJump(11, 26);
        board.addJump(20, 29);

        // Snakes
        board.addJump(27, 1);
        board.addJump(21, 9);
        board.addJump(17, 4);
        board.addJump(19, 7);

        return board;
    }
}