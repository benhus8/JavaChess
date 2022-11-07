
public class Queen {
    private final Rook queenRookMakeMove = new Rook();
    private final Bishop queenBishopMakeMove = new Bishop();

    public Boolean makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
        if (queenRookMakeMove.makeMove(position, board, isWhite, chessmanId)) {
            return true;
        } else {
            return queenBishopMakeMove.makeMove(position, board, isWhite, chessmanId);
        }
    }
}
