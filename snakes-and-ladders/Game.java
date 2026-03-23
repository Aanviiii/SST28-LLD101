import java.util.*;

public class Game {

    private final Board board;
    private final Dice dice;
    private final Queue<String> players;
    private final Map<String, Integer> positions;
    private final int winningCell;

    public Game(Board board, Dice dice, List<String> playerList) {
        this.board = board;
        this.dice = dice;
        this.players = new LinkedList<>(playerList);
        this.positions = new HashMap<>();
        this.winningCell = board.getSize();

        for (String player : playerList) {
            positions.put(player, 0);
        }
    }

    public void start() {
        List<String> winners = new ArrayList<>();

        while (players.size() > 1) {
            String current = players.poll();

            int roll = dice.roll();
            System.out.println(current + " rolled: " + roll);

            int currentPos = positions.get(current);
            int nextPos = currentPos + roll;

            if (nextPos > winningCell) {
                System.out.println(current + " cannot move (overflow)");
                players.offer(current);
                continue;
            }

            int finalPos = board.resolvePosition(nextPos);

            if (finalPos != nextPos) {
                if (finalPos < nextPos) {
                    System.out.println("Snake! " + nextPos + " -> " + finalPos);
                } else {
                    System.out.println("Ladder! " + nextPos + " -> " + finalPos);
                }
            }

            positions.put(current, finalPos);
            System.out.println(current + " is at " + finalPos);

            if (finalPos == winningCell) {
                System.out.println(current + " WON!");
                winners.add(current);
            } else {
                players.offer(current);
            }

            System.out.println("----------------------");
        }

        if (!players.isEmpty()) {
            winners.add(players.poll());
        }

        printResults(winners);
    }

    private void printResults(List<String> winners) {
        System.out.println("\nFinal Rankings:");
        for (int i = 0; i < winners.size(); i++) {
            System.out.println((i + 1) + ". " + winners.get(i));
        }
    }
}