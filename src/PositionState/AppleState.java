package PositionState;

public class AppleState extends PositionState {
    private static final AppleState instance = new AppleState();

    private AppleState(){}

    public void alter(Position position){
        position.setState(EmptyState.Instance());
    }

    public static AppleState Instance(){
        return instance;
    }
}
