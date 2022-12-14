import java.util.Arrays;

public class King implements Chessman {


    @Override
    public MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
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
                return new MakeMoveResponse(true, firstParameter + 1, secondParameter, firstParameter, secondParameter, colorId + chessmanId);

            }
            if (firstParameter - 1 >= 0 && board[firstParameter - 1][secondParameter].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter - 1, secondParameter, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (secondParameter - 1 >= 0 && board[firstParameter][secondParameter - 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter, secondParameter - 1, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (secondParameter + 1 < 8 && board[firstParameter][secondParameter + 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter, secondParameter + 1, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (firstParameter - 1 >= 0 && secondParameter + 1 < 8 && board[firstParameter - 1][secondParameter + 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter - 1, secondParameter + 1, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (firstParameter - 1 >= 0 && secondParameter - 1 >= 0 && board[firstParameter - 1][secondParameter - 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter - 1, secondParameter - 1, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (firstParameter + 1 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter + 1, secondParameter - 1, firstParameter, secondParameter, colorId + chessmanId);
            }
            if (firstParameter + 1 < 8 && secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals(colorId + chessmanId)) {
                return new MakeMoveResponse(true, firstParameter + 1, secondParameter + 1, firstParameter, secondParameter, colorId + chessmanId);
            }
        }
        return new MakeMoveResponse(false, -1, -1, -1, -1, colorId + chessmanId);
    }

//    public Boolean isCheck(String[][] board, Boolean isWhite) {
//
//        Pawn pawn = new Pawn();
//        Rook rook = new Rook();
//        Bishop bishop = new Bishop();
//        Knight knight = new Knight();
//        Queen queen = new Queen();
//        King king = new King();
//
//        int whiteKingFirstParameter = 0;
//        int whiteKingSecondParameter = 0;
//        int blackKingFirstParameter = 0;
//        int blackKingSecondParameter = 0;
//        String[][] boardCopy = Arrays.stream(board).map(String[]::clone).toArray(String[][]::new);
//
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (board[i][j].equals("0K")) {
//                    blackKingFirstParameter = i;
//                    blackKingSecondParameter = j;
//                }
//                if (board[i][j].equals("1K")) {
//                    whiteKingFirstParameter = i;
//                    whiteKingSecondParameter = j;
//                }
//            }
//        }
//        //end of for
//        String whiteKingPosition = String.valueOf(whiteKingFirstParameter) + String.valueOf(whiteKingSecondParameter);
//        String blackKingPosition = String.valueOf(blackKingFirstParameter) + String.valueOf(blackKingSecondParameter);
//        if (isWhite) {
//            System.out.println("donewhite");
//            if(pawn.makeMove(whiteKingPosition, boardCopy, false, "p")) return true;
//            if(rook.makeMove(whiteKingPosition, boardCopy, false, "R")) return true;
//            if(bishop.makeMove(whiteKingPosition, boardCopy, false, "B")) return true;
//            if(knight.makeMove(whiteKingPosition, boardCopy, false, "N")) return true;
//            return queen.makeMove(whiteKingPosition, boardCopy, false, "Q");
//        } else {
//            if(pawn.makeMove(blackKingPosition, boardCopy, true, "p")) return true;
//            if(rook.makeMove(blackKingPosition, boardCopy, true, "R")) return true;
//            if(bishop.makeMove(blackKingPosition, boardCopy, true , "B")) return true;
//            if(knight.makeMove(blackKingPosition, boardCopy, true, "N")) return true;
//            return queen.makeMove(blackKingPosition, boardCopy, true, "Q");
//        }
//    }
}
