import PositionState.Position;

import java.util.Random;

//Jonas
public class Apple {
//    static Position position;
//    private static Apple instance = new Apple();
//
//    private Apple(){
//        Position initPosition;
//
//        do {
//            // the -1, +1 combo you see makes sure that the apple never generates on the border
//            // because if it did we wouldn't see it
//            Random random = new Random();
//            initPosition = new Position(random.nextInt(Board.topRight.x -1) + 1, random.nextInt(Board.topRight.y -1) +1);
//        } while (Player.Instance().position.contains(initPosition));
//
//        position = initPosition;
//    }
//
//    public static Apple Instance(){ return instance; }
//
//    static void generatePosition(){
//        Position newPosition;
//
//        do {
//            // the -1, +1 combo you see makes sure that the apple never generates on the border
//            // because if it did we wouldn't see it
//            Random random = new Random();
//            newPosition = new Position(random.nextInt(Board.topRight.x - 1) + 1, random.nextInt(Board.topRight.y -1) + 1);
//        } while (Player.Instance().position.contains(newPosition) || newPosition.x == 0 || newPosition.y == 0);
//
//        position = newPosition;
//    }
}
