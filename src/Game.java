import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

// Jonas
public class Game {
    static boolean keepRunnning = true;
    static void run(){
        Thread plotting = new Thread(() -> {
            while (keepRunnning){
                //show game on console and move snake after
                Player.Instance().move();
                Board.plot();

                //wait depending on how many moves per sec
                int waitTime = 1000 / Player.Instance().movesPerSec;

                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                // check if player ate himself
                for (int index = 1; index < Player.Instance().position.size(); index++)
                {
                    if(Player.Instance().position.get(0).equals(Player.Instance().position.get(index)))
                    {
                        keepRunnning = false;
                    }
                }

                //check if player is still on the board
                if (Player.Instance().position.get(0).y >= Board.Instance().topRight.y || Player.Instance().position.get(0).x >= Board.Instance().topRight.x){
                    keepRunnning = false;
                }
                if (Player.Instance().position.get(0).y <= Board.Instance().bottomLeft.y || Player.Instance().position.get(0).x <= Board.Instance().bottomLeft.x){
                    keepRunnning = false;
                }

                // check if player ate the apple and if so regenerate the apples location
                if (Player.Instance().position.contains(Apple.Instance().position)){
                    Apple.Instance().generatePosition();
                    Player.Instance().score++;
                    Player.Instance().grow();
                }
            }
            Console.Clear();
        });

        Thread detectUserInput = new Thread(() -> {
            while (keepRunnning){
                char input;
                Scanner scanner = new Scanner(System.in);

                input = scanner.next().charAt(0);
                scanner.nextLine();

                switch (input) {
                    case 'w':
                        Player.Instance().curDirection = "up";
                        break;
                    case 's':
                        Player.Instance().curDirection = "down";
                        break;
                    case 'a':
                        Player.Instance().curDirection = "left";
                        break;
                    case 'd':
                        Player.Instance().curDirection = "right";
                        break;
                    default:
                }
            }
        });

        plotting.start();
        detectUserInput.start();
        try {
            plotting.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void resetGame(){
        Player.Instance().reset();
        Apple.Instance().reset();
        keepRunnning = true;
    }

    static void chooseDifficulty(){
        Scanner scanner = new Scanner(System.in);
        char userInput;
        boolean again = false;

        do{
            Console.Clear();
            System.out.println("What level of difficulty would you want to play (1-2-3)");
            userInput = scanner.next().charAt(0);

            switch (userInput){
                case '1':
                    Player.Instance().movesPerSec = 1;
                    again = false;
                    break;
                case '2':
                    Player.Instance().movesPerSec = 2;
                    again = false;
                    break;
                case '3':
                    Player.Instance().movesPerSec = 3;
                    again = false;
                    break;
                default:
                    System.out.println("Error recording your input");
                    again = true;
                    break;
            }
        }  while (again);

    }
}
