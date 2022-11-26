public class Bishop implements Chessman {


    @Override
    public MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
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
                if (firstParameter - i >= 0 && secondParameter + i < 8 && possibleMoveTopRightFlag) {
                    possibleMoveTopRightFlag = board[firstParameter - i][secondParameter + i].equals("..") || board[firstParameter - i][secondParameter + i].equals(colorId + chessmanId);
                    if (board[firstParameter - i][secondParameter + i].equals(colorId + chessmanId) && possibleMoveTopRightFlag) {
                        return new MakeMoveResponse(true, firstParameter - i, secondParameter + i, firstParameter, secondParameter, colorId + chessmanId);
                    }
                }
                if (firstParameter + i < 8 && secondParameter - i >= 0 && possibleMoveTopLeftFlag) {
                    possibleMoveTopLeftFlag = board[firstParameter + i][secondParameter - i].equals("..") || board[firstParameter + i][secondParameter - i].equals(colorId + chessmanId);
                    if (board[firstParameter + i][secondParameter - i].equals(colorId + chessmanId) && possibleMoveTopLeftFlag) {
                        return new MakeMoveResponse(true, firstParameter + i, secondParameter - i, firstParameter, secondParameter, colorId + chessmanId);

                    }
                }
                if (firstParameter + i < 8 && secondParameter + i < 8 && possibleMoveBottomRightFlag) {
                    possibleMoveBottomRightFlag = board[firstParameter + i][secondParameter + i].equals("..") || board[firstParameter + i][secondParameter + i].equals(colorId + chessmanId);
                    if (board[firstParameter + i][secondParameter + i].equals(colorId + chessmanId) && possibleMoveBottomRightFlag) {
                        return new MakeMoveResponse(true, firstParameter + i, secondParameter + i, firstParameter, secondParameter, colorId + chessmanId);

                    }
                }
                if (firstParameter - i >= 0 && secondParameter - i >= 0 && possibleMoveBottomLeftFlag) {
                    possibleMoveBottomLeftFlag = board[firstParameter - i][secondParameter - i].equals("..") || board[firstParameter - i][secondParameter - i].equals(colorId + chessmanId);
                    if (board[firstParameter - i][secondParameter - i].equals(colorId + chessmanId) && possibleMoveBottomLeftFlag) {
                        return new MakeMoveResponse(true, firstParameter - i, secondParameter - i, firstParameter, secondParameter, colorId + chessmanId);

                    }
                }
            }
        }

        return new MakeMoveResponse(false, -1, -1, -1, -1, colorId + chessmanId);
    }
}

