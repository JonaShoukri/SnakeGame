public class Board {
    static Position bottomLeft;
    static Position topRight;
    private static final Board instance = new Board();

    private Board(){
        // creating a field of 101 columns and 101 rows
        bottomLeft = new Position(0, 0);
        topRight = new Position(100, 100);
    }

    public static Board Instance(){return instance;}
}
