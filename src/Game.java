import java.io.IOException;
import java.util.HashSet;

// Jonas
public class Game {

    static void run(){
        Thread plotting = new Thread(() -> {
            while (true){
                //check if player is still on the board
                if (Player.Instance().position.get(0).y >= Board.Instance().topRight.y || Player.Instance().position.get(0).x >= Board.Instance().topRight.x){
                    break;
                }
                if (Player.Instance().position.get(0).y <= Board.Instance().bottomLeft.y || Player.Instance().position.get(0).x <= Board.Instance().bottomLeft.x){
                    break;
                }

                // check if player ate himself
                HashSet<Position> positionSet = new HashSet<>(Player.Instance().position);
                if (Player.Instance().position.size() > positionSet.size()){
                    break;
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

                System.out.println(Player.Instance().curDirection);
            }

            System.out.println("GAME OVER");
        });

        Thread detectUserInput = new Thread(() -> {
            while (true){
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
    }
}
