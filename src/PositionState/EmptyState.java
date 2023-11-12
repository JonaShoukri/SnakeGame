package PositionState;

public class EmptyState extends PositionState {
    private static final EmptyState instance = new EmptyState();

    private EmptyState(){};

    public static EmptyState Instance(){
        return instance;
    }
}
