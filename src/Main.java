public class Main {
    public static void main(String[] args) {
        for (Position position : Player.Instance().position) {
            System.out.println(position.x + ", " +  position.y);
        }
        System.out.println(Apple.Instance().position.x + ", " + Apple.Instance().position.y);
        Apple.Instance().generatePosition();
        System.out.println(Apple.Instance().position.x + ", " + Apple.Instance().position.y);
    }
}