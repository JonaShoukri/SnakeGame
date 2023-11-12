package PositionState;

public class SnakeState extends PositionState {
    private static final SnakeState instance = new SnakeState();

    private SnakeState(){}

    //
    public void alter(Position position){
        position.setState(AppleState.Instance());
    }

    public static SnakeState Instance(){
        return instance;
    }
}
