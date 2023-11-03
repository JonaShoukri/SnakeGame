import java.util.Random;

public class Apple {
    static Position position;
    private static Apple instance = new Apple();

    private Apple(){
        Position initPosition;

        do {
            Random random = new Random();
            initPosition = new Position(random.nextInt(Board.topRight.x + 1), random.nextInt(Board.topRight.y + 1));
        } while (Player.Instance().position.contains(initPosition));

        position = initPosition;
    }

    public static Apple Instance(){ return instance; }

    static void generatePosition(){
        Position newPosition;

        do {
            Random random = new Random();
            newPosition = new Position(random.nextInt(Board.topRight.x + 1), random.nextInt(Board.topRight.y + 1));
        } while (Player.Instance().position.contains(newPosition));

        position = newPosition;
    }
}
