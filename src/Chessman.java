public interface Chessman {

    //return true when move is correct, false otherwise
    MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId);
}
