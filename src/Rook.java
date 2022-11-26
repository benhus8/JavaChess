import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Rook implements Chessman {

    @Override
    public MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
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
                if (board[firstParameter][i].equals(colorId + chessmanId)) {
                    return new MakeMoveResponse(true, firstParameter, i, firstParameter, secondParameter, colorId + chessmanId);
                }
            }
            //check for left side of position
            for (int i = secondParameter - 1; i >= 0; i--) {
                possibleMoveFlag = board[firstParameter][i].equals("..") || board[firstParameter][i].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[firstParameter][i].equals(colorId + chessmanId)) {

                    return new MakeMoveResponse(true, firstParameter, i, firstParameter, secondParameter, colorId + chessmanId);
                }
            }
            //down
            for (int i = firstParameter - 1; i >= 0; i--) {
                possibleMoveFlag = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[i][secondParameter].equals(colorId + chessmanId)) {

                    return new MakeMoveResponse(true, i, secondParameter, firstParameter, secondParameter, colorId + chessmanId);
                }
            }
            for (int i = firstParameter + 1; i < 8; i++) {
                possibleMoveFlag = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + chessmanId);
                if (!possibleMoveFlag) break;
                if (board[i][secondParameter].equals(colorId + chessmanId)) {

                    return new MakeMoveResponse(true, i, secondParameter, firstParameter, secondParameter, colorId + chessmanId);
                }
            }
        }
        return new MakeMoveResponse(false, -1, -1, -1, -1, colorId + chessmanId);
    }
}
