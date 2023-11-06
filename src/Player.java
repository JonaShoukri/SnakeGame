import java.util.ArrayList;

public class Player extends Snake{
    static int score;
    private static final Player instance = new Player();
    private Player(){
        super(new ArrayList<Position>(), "up", 3);

        //setting the snake's init position (head in the middle of the field)
        Position startPosition = new Position((Board.topRight.x / 2) + 1, (Board.topRight.y / 2) + 1);
        ArrayList<Position> pos = new ArrayList<Position>();
        pos.add(new Position(startPosition.x, startPosition.y));

        for (int i = 0; i < 9; i++) {
            startPosition.y++;
            pos.add(new Position(startPosition.x, startPosition.y));
        }

        Snake.position = pos;
        score = 0;
    }

    public static Player Instance(){ return instance; }
}
