public interface Chessman {
    MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId);
}
