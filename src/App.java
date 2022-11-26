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
                {"0R", "0N", "..", "0Q", "0K", "0B", "0N", "0R"},
                {"0P", "0P", "0P", "0P", "0P", "..", "0P", "0P"},
                {"..", "..", "1P", "1P", "0P", "..", "..", ".."},
                {"..", "..", "1P", "1K", "1P", "..", "..", ".."},
                {"..", "..", "1P", "1P", "1P", "..", "..", ".."},
                {"..", "..", "..", "..", "..", "..", "..", ".."},
                {"1P", "1P", "1P", "1P", "1P", "1P", "1P", "1P"},
                {"1R", "1N", "1B", "1Q", "..", "1B", "1N", "1R"},
        };
        boolean isWhiteTurn = true;
        while (true) {

            if(gameRules.isCheck(board, isWhiteTurn)) {
                if(gameRules.isCheckMate(board, isWhiteTurn)) {
                    System.out.println("Mejcik");
                } else {
                    System.out.println("nie ma mejcika");
                }
                if( isWhiteTurn) {
                    System.out.println("    Check on white king!");
                } else {
                    System.out.println("Check on black king!");
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

            if (input.length() == 2 & input.matches("[a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = pawn.makeMove(refactor.refactorLetters(input), board, isWhiteTurn, "");
                if (makeMove.getPossibility().equals(true)) {

                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }
            if (input.length() == 3 & input.matches("[Rr][a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = rook.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "R");
                if (makeMove.getPossibility().equals(true)) {

                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }

            if (input.length() == 3 & input.matches("[Bb][a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = bishop.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "B");
                if (makeMove.getPossibility().equals(true)) {
                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }
            if (input.length() == 3 & input.matches("[Nn][a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = knight.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "N");
                if (makeMove.getPossibility().equals(true)) {
                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }
            if (input.length() == 3 & input.matches("[Qq][a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = queen.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "Q");
                if (makeMove.getPossibility().equals(true)) {
                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }
            if (input.length() == 3 & input.matches("[Kk][a-hA-H][1-8]")) {
                MakeMoveResponse makeMove = king.makeMove(refactor.refactorLetters(input.substring(1, 3)), board, isWhiteTurn, "K");
                if (makeMove.getPossibility().equals(true)) {
                    board[makeMove.getFirstParameterToMove()][makeMove.getSecondParameterToMove()] = makeMove.getChessmanId();
                    board[makeMove.getFirstParameterToClear()][makeMove.getSecondParameterToClear()] = "..";
                    isWhiteTurn = !isWhiteTurn;
                }
            }
        }
    }
}


//checking mate!
//            if(isWhiteTurn && gameRules.isCheck(board, false) && blackCheck) {
//                System.out.println("         ---CHECK MATE!---");
//                System.out.println("         ---WHITE WINS!---");
//                break;
//            }
//            if(!isWhiteTurn && gameRules.isCheck(board, true) && whiteCheck) {
//                System.out.println("         ---CHECK MATE!---");
//                System.out.println("         ---BLACK WINS!---");
//                break;

//check!
//            if(gameRules.isCheck(board, isWhiteTurn)) {
//                if(isWhiteTurn) {
//                    whiteCheck = true;
//                } else {
//                    blackCheck = true;
//                }
//                System.out.println("CHECK");
//            }  else {
//                if(isWhiteTurn) {
//                    whiteCheck = false;
//                } else {
//                    blackCheck = false;
//                }
//            }
// check if there is only 2 kings on the board
//c heck if is checked know
// if yes
// check is check mate
// continuation
// end of the game!