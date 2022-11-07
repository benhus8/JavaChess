import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Rook implements Chessman {

    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));
        //flag for checking is move can be done
        boolean possibleMoveFlag = true;
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
            for (int i = secondParameter + 1; i < 8; i++) {
                possibleMoveFlag = board[firstParameter][i].equals("..") || board[firstParameter][i].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                //make move if true when not check next if
                if (board[firstParameter][i].equals(colorId + chessmanId)) {
                    board[firstParameter][i] = "..";
                    board[firstParameter][secondParameter] = colorId + chessmanId;
                    return true;
                }
            }
            //check for left side of position
            for (int i = secondParameter - 1; i >= 0; i--) {
                possibleMoveFlag = board[firstParameter][i].equals("..") || board[firstParameter][i].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[firstParameter][i].equals(colorId + chessmanId)) {
                    board[firstParameter][i] = "..";
                    board[firstParameter][secondParameter] = colorId + chessmanId;
                    return true;
                }
            }
            //down
            for (int i = firstParameter - 1; i >= 0; i--) {
                possibleMoveFlag = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[i][secondParameter].equals(colorId + chessmanId)) {
                    board[i][secondParameter] = "..";
                    board[firstParameter][secondParameter] = colorId + chessmanId;
                    return true;
                }
            }
            for (int i = firstParameter + 1; i < 8; i++) {
                possibleMoveFlag = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[i][secondParameter].equals(colorId + chessmanId)) {
                    board[i][secondParameter] = "..";
                    board[firstParameter][secondParameter] = colorId + chessmanId;
                    return true;
                }
            }
        }
        return false;
    }
}
