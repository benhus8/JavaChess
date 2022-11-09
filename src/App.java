import java.util.Scanner;


public class App {
    static Utils utils = new Utils();
    static Pawn pawn = new Pawn();
    static Rook rook = new Rook();
    static Bishop bishop = new Bishop();

    static Knight knight = new Knight();

    static Queen queen = new Queen();

    static King king = new King();
    public static void main(String[] args) {

        String[][] board = {
                {"0R", "0N", "0B", "0K", "0Q", "0B", "0N", "0R"},
                {"0P", "0P", "0P", "0P", "0P", "0P", "0P", "0P"},
                {"..", "..", "..", "0K", "..", "..", "..", ".."},
                {"..", "..", "..", "1N", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"1P", "1P", "1P", "1P", "1P", "1P", "1P", "1P"},
                {"1R", "1N", "1B", "1K", "1Q", "1B", "1N", "1R"},
        };
        boolean isWhiteTurn = true;
        while (true) {
            // check if there is only 2 kings on the board
            //check if is checked know
            //if yes
            //check is check mate
            //continuation
            // end of the game!
            if (isWhiteTurn) {
                System.out.println("         ---WHITE MOVE---");
            } else {
                System.out.println("         ---BLACK MOVE---");
            }
            utils.printBoard(board);
            Refactor refactor = new Refactor();
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            input = input.trim();
            //if Pawn move
            if (input.length() == 2 & input.matches("[a-hA-H][1-8]")) {
                if (pawn.makeMove(refactor.refactorLetters(input), board, isWhiteTurn, "")) isWhiteTurn = !isWhiteTurn;
                else System.out.println("Wrong move parameter, try again!");
            }
            if (input.length() == 3 & input.matches("[Rr][a-hA-H][1-8]")) {
                if (rook.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "R")) isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Bb][a-hA-H][1-8]")) {
                if (bishop.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "B")) isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Nn][a-hA-H][1-8]")) {
                if (knight.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "N")) isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Qq][a-hA-H][1-8]")) {
                if (queen.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "Q")) isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Kk][a-hA-H][1-8]")) {
                if (king.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "K")) isWhiteTurn = !isWhiteTurn;
            }
        }
    }
}

