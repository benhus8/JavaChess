import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Rook implements Chessman {

    static final String rookId = "R";

    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));
        //flag for checking is move can be done
        boolean possibleHorizontalRightMove = true;
        boolean possibleHorizontalFromLeft = true;
        boolean possibleVerticaFromDown = true;
        boolean possibleVerticalMove = true;
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
                possibleHorizontalRightMove = board[firstParameter][i].equals("..") || board[firstParameter][i].equals(colorId + rookId);
                if (!possibleHorizontalRightMove) break;
                //make move if true when not check next if
                if (board[firstParameter][i].equals(colorId + rookId)) {
                    board[firstParameter][i] = "..";
                    board[firstParameter][secondParameter] = colorId + rookId;
                    return true;
                }
            }
            //check for left side of position
            for (int i = secondParameter - 1; i >= 0; i--) {
                possibleHorizontalFromLeft = board[firstParameter][i].equals("..") || board[firstParameter][i].equals(colorId + rookId);
                if (!possibleHorizontalFromLeft) break;
                if (board[firstParameter][i].equals(colorId + rookId)) {
                    board[firstParameter][i] = "..";
                    board[firstParameter][secondParameter] = colorId + rookId;
                    return true;
                }
            }
            //down
            for (int i = firstParameter - 1; i >= 0; i--) {
                possibleVerticaFromDown = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + rookId);
                if (!possibleVerticaFromDown) break;
                if (board[i][secondParameter].equals(colorId + rookId)) {
                    board[i][secondParameter] = "..";
                    board[firstParameter][secondParameter] = colorId + rookId;
                    return true;
                }
            }
            for (int i = firstParameter + 1; i < 8; i++) {
                possibleVerticalMove = board[i][secondParameter].equals("..") || board[i][secondParameter].equals(colorId + rookId);
                if (!possibleVerticalMove) break;
                if (board[i][secondParameter].equals(colorId + rookId)) {
                    board[i][secondParameter] = "..";
                    board[firstParameter][secondParameter] = colorId + rookId;
                    return true;
                }
            }
        }
        return false;
    }
}
