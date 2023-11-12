package PositionState;

public class PositionState {
    public void alter(Position position){
        position.setState(BoarderState.Instance());
    }
}
