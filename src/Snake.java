import java.util.ArrayList;

public class Snake {
    static ArrayList<Position> position;
    static String curDirection;
    static int movesPerSec;

    Snake(ArrayList<Position> pos, String dir, int mps){
        position = pos;
        curDirection = dir;
        movesPerSec = mps;
    }
}
