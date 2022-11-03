public class Utils {

    public String refactorLetters(String movePosition) {
        char capital = Character.toUpperCase(movePosition.charAt(0));
        int asciiValue = (int) capital - 65;
        return  movePosition.charAt(1) + String.valueOf(asciiValue);
    }

    public void printBoard(String[][] board1) {
        System.out.println("   A   B   C   D   E   F   G   H");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 8; j++) {
                System.out.print("  " + board1[i][j]);
            }
            System.out.print(" " + (i+1));
            System.out.println();
        }
        System.out.println("   A   B   C   D   E   F   G   H");
    }
}
