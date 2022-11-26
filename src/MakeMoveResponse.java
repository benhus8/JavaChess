
public class MakeMoveResponse {

    private final Boolean possibility;

    private final int firstParameterToClear;

    private final int secondParameterToClear;

    private final int firstParameterToMove;

    private final int secondParameterToMove;
    private final String chessmanId;

    public MakeMoveResponse(boolean possibility, int firstParameterToClear, int secondParameterToClear,int firstParameterToMove,
                            int secondParameterToMove, String chessmanId) {
        this.possibility = possibility;
        this.firstParameterToMove = firstParameterToMove;
        this.secondParameterToMove = secondParameterToMove;
        this.firstParameterToClear=firstParameterToClear;
        this.secondParameterToClear = secondParameterToClear;
        this.chessmanId = chessmanId;
    }

    public Boolean getPossibility() {
        return possibility;
    }
    public int getFirstParameterToClear(){
        return firstParameterToClear;
    }
    public int getSecondParameterToClear(){
        return secondParameterToClear;
    }
    public String getChessmanId() {
        return chessmanId;
    }
    public int getFirstParameterToMove(){return firstParameterToMove;}
    public int getSecondParameterToMove(){return secondParameterToMove;}
}

