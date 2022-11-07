public class Knight implements Chessman {
    static final String knightId = "N";

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
            //long L right top
            if (firstParameter - 1 >= 0 && secondParameter < 8 && board[firstParameter - 1][secondParameter + 2].equals(colorId + knightId)) {
                board[firstParameter - 1][secondParameter + 2] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
            //short L right top
            if (firstParameter - 2 >= 0 && secondParameter < 8 && board[firstParameter - 2][secondParameter + 1].equals(colorId + knightId)) {
                board[firstParameter - 2][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
            //short L left top
            if (firstParameter - 2 >= 0 && secondParameter - 1 >= 0 && board[firstParameter - 2][secondParameter - 1].equals(colorId + knightId)) {
                board[firstParameter - 2][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }

            //long L left top
            if (firstParameter - 1 >= 0 && secondParameter - 2 >= 0 && board[firstParameter - 1][secondParameter - 2].equals(colorId + knightId)) {
                board[firstParameter - 1][secondParameter - 2] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
            //long L right bot
            if (firstParameter + 1 < 8 && secondParameter + 2 < 8 && board[firstParameter + 1][secondParameter + 2].equals(colorId + knightId)) {
                board[firstParameter + 1][secondParameter + 2] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
            //short L right bot
            if (firstParameter + 2 < 8 && secondParameter + 1 < 8 && board[firstParameter + 2][secondParameter + 1].equals(colorId + knightId)) {
                board[firstParameter + 2][secondParameter + 1] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
            //short L left bot
            if (firstParameter + 2 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 2][secondParameter - 1].equals(colorId + knightId)) {
                board[firstParameter + 2][secondParameter - 1] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }

            //long L left bot
            if (firstParameter + 1 < 8 && secondParameter - 2 >= 0 && board[firstParameter + 1][secondParameter - 2].equals(colorId + knightId)) {
                board[firstParameter + 1][secondParameter - 2] = "..";
                board[firstParameter][secondParameter] = colorId + knightId;
                return true;
            }
        }

        return false;
    }
}

