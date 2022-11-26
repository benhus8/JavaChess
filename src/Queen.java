
public class Queen {
    private final Rook queenRookMakeMove = new Rook();
    private final Bishop queenBishopMakeMove = new Bishop();

    public MakeMoveResponse makeMove(String position, String[][] board, Boolean isWhite, String chessmanId) {
        MakeMoveResponse makeMove = queenRookMakeMove.makeMove(position, board, isWhite, chessmanId);
        if (makeMove.getPossibility()) {
            return makeMove;
        } else {
            return queenBishopMakeMove.makeMove(position, board, isWhite, chessmanId);
        }
    }
}
