import java.util.Arrays;

public class GameRules {
    public Boolean isCheck(String[][] board, Boolean isWhite) {
        String kingPosition = "";
        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        String colorId;
        if (isWhite) {
            colorId = "1";
        } else colorId = "0";

        //find King
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(colorId + "K")) {
                    kingPosition = String.valueOf(i) + String.valueOf(j);
                }
            }
        }
        //is something ATTACKING MY KING! == is !isWhite attacking king!
//        if (pawn.makeMove(kingPosition, board, !isWhite, "P").getPossibility()) return true;
//        if (rook.makeMove(kingPosition, board, !isWhite, "R").getPossibility()) return true;
//        if (bishop.makeMove(kingPosition, board, !isWhite, "B").getPossibility()) return true;
//        if (knight.makeMove(kingPosition, board, !isWhite, "N").getPossibility()) return true;
//        if (queen.makeMove(kingPosition, board, !isWhite, "Q").getPossibility()) return true;
        return attackOnField(board, isWhite, kingPosition);

    }

    public Boolean isCheckMate(String[][] board, Boolean isWhite) {
        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        King king = new King();
        int firstParameterKing = 0;
        int secondParameterKing = 0;
        String colorId;
        if (isWhite) {
            colorId = "1";
        } else colorId = "0";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(colorId + "K")) {
                    firstParameterKing = i;
                    secondParameterKing = j;
                }
            }
        }
        //if king move anywhere
        if (secondParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (firstParameterKing + 1 < 8 && secondParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }

        if (firstParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (firstParameterKing + 1 < 8 && secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (firstParameterKing - 1 >= 0 && secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (firstParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        if (firstParameterKing - 1 >= 0 && secondParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition))
                return false;
        }
        //if anything can kill the checking chessPiece



        return true;
    }

    private Boolean attackOnField(String[][] board, Boolean isWhite, String position) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        String[][] boardCopy = new String[board.length][];
        for (int i = 0; i < board.length; i++)
            boardCopy[i] = board[i].clone();

        String colorId;
        if (isWhite) {
            colorId = "0";
        } else {
            colorId = "1";
        }

        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();


        if (rook.makeMove(position, board, !isWhite, "R").getPossibility()) {
            return true;
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (rook.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return true;
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }
        if (bishop.makeMove(position, board, !isWhite, "B").getPossibility()) {
            return true;
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (bishop.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return true;
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }
        if (knight.makeMove(position, board, !isWhite, "N").getPossibility()) {
            return true;
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (knight.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return true;
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }
        if (queen.makeMove(position, board, !isWhite, "Q").getPossibility()) {
            return true;
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (queen.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return true;
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }

        if (!isWhite) {
            if (firstParameter + 1 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals("1P")) {
                return true;
            } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
                boardCopy[firstParameter][secondParameter] = "..";
                if (queen.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                    boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                    return true;
                } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
            }

            if (firstParameter + 1 < 8 && secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals("1P")) {
                return true;
            } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
                boardCopy[firstParameter][secondParameter] = "..";
                if (queen.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                    boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                    return true;
                } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
            }
        } else {
            if (firstParameter - 1 >= 0 && secondParameter - 1 >= 0 && board[firstParameter - 1][secondParameter - 1].equals("0P"))
                return true;
            }
            if (firstParameter - 1 >= 0 && secondParameter + 1 < 8 && board[firstParameter - 1][secondParameter + 1].equals("0P"))
                return true;

        return false;
    }
}

