import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameRules {
    public Boolean isCheck(String[][] board, Boolean isWhite) {

        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        King king = new King();

        int whiteKingFirstParameter = 0;
        int whiteKingSecondParameter = 0;
        int blackKingFirstParameter = 0;
        int blackKingSecondParameter = 0;
        String[][] boardCopy = Arrays.stream(board).map(String[]::clone).toArray(String[][]::new);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals("0K")) {
                    blackKingFirstParameter = i;
                    blackKingSecondParameter = j;
                }
                if (board[i][j].equals("1K")) {
                    whiteKingFirstParameter = i;
                    whiteKingSecondParameter = j;
                }
            }
        }
        //end of for
        String whiteKingPosition = String.valueOf(whiteKingFirstParameter) + String.valueOf(whiteKingSecondParameter);
        String blackKingPosition = String.valueOf(blackKingFirstParameter) + String.valueOf(blackKingSecondParameter);
        if (isWhite) {
            if(pawn.makeMove(whiteKingPosition, boardCopy, false, "p")) return true;
            if(rook.makeMove(whiteKingPosition, boardCopy, false, "R")) return true;
            if(bishop.makeMove(whiteKingPosition, boardCopy, false, "B")) return true;
            if(knight.makeMove(whiteKingPosition, boardCopy, false, "N")) return true;
            return queen.makeMove(whiteKingPosition, boardCopy, false, "Q");
        } else {
            if(pawn.makeMove(blackKingPosition, boardCopy, true, "p")) return true;
            if(rook.makeMove(blackKingPosition, boardCopy, true, "R")) return true;
            if(bishop.makeMove(blackKingPosition, boardCopy, true , "B")) return true;
            if(knight.makeMove(blackKingPosition, boardCopy, true, "N")) return true;
            return queen.makeMove(blackKingPosition, boardCopy, true, "Q");
        }
    }
    public Boolean isCheckMate(String[][] board, Boolean isWhite) {
        // 0. Find King! :))
        // 1. check attacking on king position field - you know attacking field and chessman
        // 2. check attacking on fields near king - add to list
        // 3. check is sth attacking on fields from point 1 - add to possibleMove array
        // 4. if possibleMove array.size() == 0 checkMate !isWhite wins!
        // 4. return possible move array
        String colorId;
        int[] kingPosition = new int[2];
        if (isWhite)  colorId = "1";
        else colorId = "0";
        //0.
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                if (board[i][j].equals(colorId + "K")) {
                    kingPosition[0] = i;
                    kingPosition[1] = j;
                }
            }
        }
        //1.
        if(!isWhite) {
            System.out.println(Arrays.toString(isAttacking(board, isWhite, kingPosition).get(0)));
        }
        return false;
    }
    public List<int[]> isAttacking(String[][] board, Boolean isWhite, int[] field) {
//        int[][]  attackingChessman = new int[0][];
        List<int[]> attackingChessman = new ArrayList<>();
        int firstParameter = field[0];
        int secondParameter = field[1];

        String colorId;
        if (isWhite)  colorId = "0";
        else colorId = "1";
        // pawn
        // bishop
        // queen
        // rook
        // knight

        if (isWhite) {
            //pawn
            if(firstParameter - 1 >= 0){
                if(secondParameter - 1 >= 0 && board[firstParameter - 1][secondParameter - 1].equals(colorId + "P")) {
                    int[] attackingFieldPosition = {firstParameter - 1, secondParameter - 1};
                    attackingChessman.add(attackingFieldPosition);
                }
                if(secondParameter + 1 < 8 && board[firstParameter - 1][secondParameter + 1].equals(colorId + "P")) {
                    int[] attackingFieldPosition = {firstParameter - 1, secondParameter + 1};
                    attackingChessman.add(attackingFieldPosition);
                }
            }
            //bishop

        } else {
            //pawn
            if(firstParameter + 1 < 8){
                if(secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals(colorId + "P")) {
                    int[] attackingFieldPosition = {firstParameter + 1, secondParameter - 1};
                    attackingChessman.add(attackingFieldPosition);
                }
                if(secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals(colorId + "P")) {
                    int[] attackingFieldPosition = {firstParameter + 1, secondParameter + 1};
                    attackingChessman.add(attackingFieldPosition);
                }
            }
        }
        return attackingChessman;
    }
}
