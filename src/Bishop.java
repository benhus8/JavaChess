public class Bishop implements Chessman {
    static final String bishopId = "B";

    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        boolean possibleMoveTopRightFlag = true;
        boolean possibleMoveTopLeftFlag = true;
        boolean possibleMoveBottomRightFlag = true;
        boolean possibleMoveBottomLeftFlag = true;

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
            //check top right diagonal
            for (int i = 1; i < 8; i++) {
                    if(firstParameter - i >= 0 && secondParameter + i < 8) {
                        possibleMoveTopRightFlag = board[firstParameter - i][secondParameter + i].equals("..") || board[firstParameter - i][secondParameter + i].equals(colorId + bishopId);
                        if (board[firstParameter - i][secondParameter + i].equals(colorId + bishopId) && possibleMoveTopRightFlag) {
                            board[firstParameter - i][secondParameter + i] = "..";
                            board[firstParameter][secondParameter] = colorId + bishopId;
                            return true;
                        }
                    }
                    if(firstParameter + i < 8  && secondParameter - i >= 0) {
                        possibleMoveTopLeftFlag = board[firstParameter + i][secondParameter - i].equals("..") || board[firstParameter + i][secondParameter - i].equals(colorId + bishopId);
                        if (board[firstParameter + i][secondParameter - i].equals(colorId + bishopId) && possibleMoveTopLeftFlag) {
                            board[firstParameter + i][secondParameter - i] = "..";
                            board[firstParameter][secondParameter] = colorId + bishopId;
                            return true;
                        }
                    }
                    if(firstParameter + i < 8  && secondParameter + i < 8) {
                        possibleMoveBottomRightFlag = board[firstParameter + i][secondParameter + i].equals("..") || board[firstParameter + i][secondParameter + i].equals(colorId + bishopId);
                        if (board[firstParameter + i][secondParameter + i].equals(colorId + bishopId) && possibleMoveBottomRightFlag) {
                            board[firstParameter + i][secondParameter + i] = "..";
                            board[firstParameter][secondParameter] = colorId + bishopId;
                            return true;
                        }
                    }
                    if(firstParameter - i >= 0  && secondParameter - i >= 0) {
                        possibleMoveBottomLeftFlag = board[firstParameter - i][secondParameter - i].equals("..") || board[firstParameter - i][secondParameter - i].equals(colorId + bishopId);
                        if (board[firstParameter - i][secondParameter - i].equals(colorId + bishopId) && possibleMoveBottomLeftFlag) {
                            board[firstParameter - i][secondParameter - i] = "..";
                            board[firstParameter][secondParameter] = colorId + bishopId;
                            return true;
                        }
                    }
                //make move if true when not check next if
            }
        }

        return false;
    }
}

