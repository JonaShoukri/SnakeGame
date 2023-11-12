package PositionState;

public class BoarderState extends PositionState {
    private static final BoarderState instance = new BoarderState();

    private BoarderState(){}

    public void alter(Position position){
        position.setState(SnakeState.Instance());
    }

    public static BoarderState Instance(){
        return instance;
    }
}
