public class Main {
    public static void main(String[] args) {
        int fieldSize = 10;
        int xPosition = 0;
        int yPosition = fieldSize - 1;

        // Display the field with the x in the initial position
        displayField(fieldSize, xPosition, yPosition);
    }

    private static void displayField(int size, int x, int y) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == y && j == x) {
                    System.out.print("X");
                } else if (i == 0 || i == size - 1) {
                    System.out.print("_");
                } else if (j == 0 || j == size - 1) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}