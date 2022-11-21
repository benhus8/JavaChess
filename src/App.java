import java.util.Scanner;


public class App {
    static GameRules gameRules = new GameRules();
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
                {"..", "..", "..", "..", "1P", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"1P", "1P", "1P", "1P", "1P", "1P", "1P", "1P"},
                {"1R", "1N", "1B", "1K", "1Q", "1B", "1N", "1R"},
        };
        boolean isWhiteTurn = true;
        boolean check= false;
        boolean whiteCheck = false;
        boolean blackCheck = false;
        while (true) {
            gameRules.isCheckMate(board, isWhiteTurn);


            //checking mate!
            if(isWhiteTurn && gameRules.isCheck(board, false) && blackCheck) {
                System.out.println("         ---CHECK MATE!---");
                System.out.println("         ---WHITE WINS!---");
                break;
            }
            if(!isWhiteTurn && gameRules.isCheck(board, true) && whiteCheck) {
                System.out.println("         ---CHECK MATE!---");
                System.out.println("         ---BLACK WINS!---");
                break;
            }
            //check!
            if(gameRules.isCheck(board, isWhiteTurn)) {
                if(isWhiteTurn) {
                    whiteCheck = true;
                } else {
                    blackCheck = true;
                }
                System.out.println("CHECK");
            }  else {
                if(isWhiteTurn) {
                    whiteCheck = false;
                } else {
                    blackCheck = false;
                }
            }
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
                if (rook.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "R"))
                    isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Bb][a-hA-H][1-8]")) {
                if (bishop.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "B"))
                    isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Nn][a-hA-H][1-8]")) {
                if (knight.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "N"))
                    isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Qq][a-hA-H][1-8]")) {
                if (queen.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "Q"))
                    isWhiteTurn = !isWhiteTurn;
            }
            if (input.length() == 3 & input.matches("[Kk][a-hA-H][1-8]")) {
                if (king.makeMove((refactor.refactorLetters(input.substring(1, 3))), board, isWhiteTurn, "K"))
                    isWhiteTurn = !isWhiteTurn;
            }
        }
    }
}

