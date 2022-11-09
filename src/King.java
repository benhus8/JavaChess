public class King implements Chessman {
    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        String colorId;
        String enemyColorId;
        if (isWhite) {
            colorId = "1";
            enemyColorId = "0";
        } else {
            colorId = "0";
            enemyColorId = "1";
        }

        if (board[firstParameter][secondParameter].startsWith(enemyColorId) || board[firstParameter][secondParameter].equals("..")) {
            if (firstParameter + 1 < 8 && board[firstParameter + 1][secondParameter].equals(colorId + chessmanId)) {
                board[firstParameter + 1][secondParameter] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (firstParameter - 1 >= 0 && board[firstParameter - 1][secondParameter].equals(colorId + chessmanId)) {
                board[firstParameter - 1][secondParameter] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (secondParameter - 1 >= 0 && board[firstParameter][secondParameter - 1].equals(colorId + chessmanId)) {
                board[firstParameter][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (secondParameter + 1 < 8 && board[firstParameter][secondParameter + 1].equals(colorId + chessmanId)) {
                board[firstParameter][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (firstParameter - 1 >= 0&& secondParameter + 1 < 8 && board[firstParameter- 1][secondParameter + 1].equals(colorId + chessmanId)) {
                board[firstParameter - 1][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (firstParameter - 1 >= 0&& secondParameter - 1 >= 0 && board[firstParameter- 1][secondParameter - 1].equals(colorId + chessmanId)) {
                board[firstParameter - 1][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (firstParameter + 1 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals(colorId + chessmanId)) {
                board[firstParameter + 1][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
            if (firstParameter + 1 < 8 && secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals(colorId + chessmanId)) {
                board[firstParameter + 1][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = colorId + chessmanId;
                return true;
            }
        }
        return false;
    }
}
