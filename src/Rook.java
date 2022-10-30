import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Rook implements Chessman{
    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));
        //rook standard move for black

        boolean possibleHorizontalRightMove = true;
        //horizontal check for right
        for(int i = secondParameter + 1; i < 8; i++) {
            if(board[firstParameter][i].equals("..")) {
                possibleHorizontalRightMove = true;
            } else {
                possibleHorizontalRightMove = false;
            }
            //make move if true when not check next if
            if(!isWhite && board[firstParameter][i].equals("0R") && possibleHorizontalRightMove) {
                board[firstParameter][i] = "..";
                board[firstParameter][secondParameter] = "0R";
                return true;
            }
        }
        //make a validation of figure and trim inputted string
        //horizontal check for left
        // check up
        //check down


        return false;
    }
}
