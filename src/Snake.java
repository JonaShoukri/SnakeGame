import java.util.ArrayList;

// Jonas
public class Snake {
    static ArrayList<Position> position;
    static String curDirection;
    static int movesPerSec;

    Snake(ArrayList<Position> pos, String dir, int mps){
        position = pos;
        curDirection = dir;
        movesPerSec = mps;
    }

    public static void move(){
        Position newPosition;

        switch (curDirection){
            case "up":
                newPosition = new Position(position.get(0).x, position.get(0).y - 1);
                position.add(0, newPosition);
                position.remove(position.size() - 1);
                break;
            case "down":
                newPosition = new Position(position.get(0).x, position.get(0).y + 1);
                position.add(0, newPosition);
                position.remove(position.size() - 1);
                break;
            case "left":
                newPosition = new Position(position.get(0).x - 1, position.get(0).y);
                position.add(0, newPosition);
                position.remove(position.size() - 1);
                break;
            case "right":
                newPosition = new Position(position.get(0).x + 1, position.get(0).y);
                position.add(0, newPosition);
                position.remove(position.size() - 1);
                break;
            default:
                break;
        }
    }

    public static void grow(){
        Position tail = position.get(position.size() - 1);
        Position secondToLast = position.get(position.size() - 2);

        int deltaX = tail.x - secondToLast.x;
        int deltaY = tail.y - secondToLast.y;

        int newX = tail.x + deltaX;
        int newY = tail.y + deltaY;

        Position newTail = new Position(newX, newY);
        position.add(newTail);
    }
}
