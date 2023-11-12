import PositionState.AppleState;
import PositionState.Position;

public class Main {
    public static void main(String[] args) {
        Position position1 = new Position(5, 5);
        Position position2 = new Position(5, 5);

        for (int i = 0; i <= 4; i++) {
            if (position1.getState() == AppleState.Instance()) System.out.println(position1.getState());
            else System.out.println();
            position1.alterState();
        }


    }
}
