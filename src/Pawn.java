public class Pawn implements Chessman {
    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {

        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        if (isWhite) {
            if (firstParameter == 4 && board[6][secondParameter].equals("1P")) {
                board[4][secondParameter] = "1P";
                board[6][secondParameter] = "..";
                return true;
            }
            if (firstParameter + 1 < 8 && board[firstParameter + 1][secondParameter].equals("1P") &&
                    board[firstParameter][secondParameter].equals("..")) {
                board[firstParameter + 1][secondParameter] = "..";
                board[firstParameter][secondParameter] = "1P";
                return true;
                //attack move for white from left side
            } else if (firstParameter + 1 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals("1P") &&
                    String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("0")) {
                board[firstParameter + 1][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = "1P";
                return true;
                //attack move for white from right side
            } else if (firstParameter + 1 < 8 && secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals("1P") &&
                    String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("0")) {
                board[firstParameter + 1][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = "1P";
                return true;
            }
        } else {
            if (firstParameter == 3 && board[1][secondParameter].equals("0P")) {
                board[3][secondParameter] = "0P";
                board[1][secondParameter] = "..";
                return true;
            }
            if (firstParameter - 1 >= 0 && board[firstParameter - 1][secondParameter].equals("0P") &&
                    board[firstParameter][secondParameter].equals("..")) {
                board[firstParameter - 1][secondParameter] = "..";
                board[firstParameter][secondParameter] = "0P";
                return true;
                //attack move for black from left side
            } else if (firstParameter - 1 >= 0 && secondParameter - 1 >= 0 && board[firstParameter - 1][secondParameter - 1].equals("0P") &&
                    String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("1")) {
                board[firstParameter - 1][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = "0P";
                return true;
                //attack move for black from right side
            } else if (firstParameter - 1 >= 0 && secondParameter + 1 < 8 && board[firstParameter - 1][secondParameter + 1].equals("0P") &&
                    String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("1")) {
                board[firstParameter - 1][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = "0P";
                return true;
            }
        }
        return false;
    }
}

