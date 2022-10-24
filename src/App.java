import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Utils utils = new Utils();
        Pawn pawn = new Pawn();
        //printing board
//        String[][] board = new String[8][8];
//        System.out.println("   A   B   C   D   E   F   G   H");
//        for (int i = 0; i < 8; i++) {
//            System.out.print(i + 1);
//            for (int j = 0; j < 8; j++) {
//                System.out.print("  " + board1[i][j]);
//            }
//            System.out.print(" " + (i+1));
//            System.out.println();
//        }
//        System.out.println("   A   B   C   D   E   F   G   H");
        String[][] board = {
                {"0R", "0N", "0B", "0K", "0Q", "0B", "0N", "0R"},
                {"0P", "0P", "0P", "0P", "0P", "0P", "0P", "0P"},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"1P", "1P", "1P", "1P", "1P", "1P", "1P", "1P"},
                {"1R", "1N", "1B", "1K", "1Q", "1B", "1N", "1R"},
        };
    boolean isWhiteTurn = true;

        while (true) {

            utils.printBoard(board);
            Refactor refactor = new Refactor();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            pawn.makeMove(refactor.refactorLetters(input), board, isWhiteTurn);
            isWhiteTurn = !isWhiteTurn;
        }
    }
}

