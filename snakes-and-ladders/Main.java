import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Board board = BoardBuilder.buildBoard();

        List<String> players = Arrays.asList("P1", "P2", "P3");

        Dice dice = new StandardDice();

        Game game = new Game(board, dice, players);
        game.start();
    }
}