import java.util.ArrayList;

public class Board {
    static Position bottomLeft;
    static Position topRight;
    private static final Board instance = new Board();

    private Board(){
        // creating a field of 101 columns and 101 rows
        bottomLeft = new Position(0, 0);
        topRight = new Position(31, 31);
    }

    public static Board Instance(){return instance;}

    static void plot(){
        Console.Clear();

        ArrayList<Position> takenPositions = new ArrayList<Position>();
        takenPositions.add(Apple.Instance().position);
        takenPositions.addAll(Player.Instance().position);

        Position position = new Position(0,0);

        for(int y = 0; y <= Board.Instance().topRight.y; y++)
        {
            for(int x = 0; x <= Board.Instance().topRight.x; x++)
            {
                position.x = x;
                position.y = y;
                if(x == Board.Instance().topRight.x || y == Board.Instance().topRight.y || x == Board.Instance().bottomLeft.x || y == Board.Instance().bottomLeft.y )
                {
                    System.out.print("-\t");
                }
                else if (x == takenPositions.get(0).x && y == takenPositions.get(0).y)
                {
                    System.out.print("@\t");
                }
                else if (takenPositions.contains(position))
                {
                    System.out.print("S\t");
                }
                else
                {
                    System.out.print(" \t");
                }

            }
            System.out.println();
        }
        System.out.println("Player score: " + Player.Instance().score);
    }
}
