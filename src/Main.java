import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean again = true;
        char userInput;
        Game game = new Game();



        System.out.println("Press anything when you're ready to start");
        scanner.nextLine();

        do {
            game.chooseDifficulty();
            game.run();

            System.out.println("GAME OVER with a score of " + Player.Instance().score);
            System.out.println("Do you wish to play again? (y/n)");
            userInput = scanner.next().charAt(0);

            again = userInput != 'n';

            game.resetGame();
        } while (again);
    }
}
