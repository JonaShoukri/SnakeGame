package PositionState;

//Jonas
public class Position {
    int x;
    int y;
    PositionState state;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.state = EmptyState.Instance();
    }

    public PositionState getState(){
        return this.state;
    }

    public void setState(PositionState newState){
        this.state = newState;
    }

    public void alterState(){
        this.state.alter(this);
    }

    // we ran into issues when comparing positions due to the fact that the == operator was comparing the
    // memory location instead of the values inside so we override the equals as seen below:
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position position = (Position) obj;
        return x == position.x && y == position.y;
    }
}
