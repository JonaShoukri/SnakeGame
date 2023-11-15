import java.io.IOException;
import java.util.HashSet;

// Jonas
public class Game {
    static boolean keepRunnning = true;
    static void run(){
        Thread plotting = new Thread(() -> {
            while (keepRunnning){
                //check if player is still on the board
                if (Player.Instance().position.get(0).y >= Board.Instance().topRight.y || Player.Instance().position.get(0).x >= Board.Instance().topRight.x){
                    keepRunnning = false;
                    break;
                }
                if (Player.Instance().position.get(0).y <= Board.Instance().bottomLeft.y || Player.Instance().position.get(0).x <= Board.Instance().bottomLeft.x){
                    keepRunnning = false;
                    break;
                }

                // check if player ate himself
                for (int index = 1; index < Player.Instance().position.size(); index++)
                {
                    if(Player.Instance().position.get(index).x == Player.Instance().position.get(0).x && Player.Instance().position.get(index).y == Player.Instance().position.get(0).y)
                    {
                        keepRunnning = false;
                        break;
                    }

                }

                // check if player ate the apple and if so regenerate the apples location
                if (Player.Instance().position.contains(Apple.Instance().position)){
                    Apple.Instance().generatePosition();
                    Player.Instance().score++;
                    Player.Instance().grow();
                }

                //show game on console and move snake after
                Board.plot();
                Player.Instance().move();

                //wait depending on how many moves per sec
                int waitTime = 1000 / Player.Instance().movesPerSec;

                try {
                    Thread.sleep(waitTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Console.Clear();
        });

        Thread detectUserInput = new Thread(() -> {
            while (keepRunnning){
                char input;

                try {
                    input = (char) System.in.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

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
}
