public class Pawn implements Chessman {
    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite) {

        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));


        //special 2 fields forward move for White!
        if (firstParameter == 4 && isWhite && board[6][secondParameter].equals("1P")) {
            board[4][secondParameter] = "1P";
            board[6][secondParameter] = "..";
            return true;
        }
        //special 2 fields forward move for Black!
        if (firstParameter == 3 && !isWhite && board[1][secondParameter].equals("0P")) {
            board[3][secondParameter] = "0P";
            board[1][secondParameter] = "..";
            return true;
        }
        //normal move for black
        if (board[firstParameter - 1][secondParameter].equals("0P") && !isWhite &&
                board[firstParameter][secondParameter].equals("..")) {
            board[firstParameter - 1][secondParameter] = "..";
            board[firstParameter][secondParameter] = "0P";
            return true;
            //attack move for black from left side
        } else if (board[firstParameter - 1][secondParameter - 1].equals("0P")  && !isWhite &&
                String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("1")) {
            board[firstParameter - 1][secondParameter - 1] = "..";
            board[firstParameter][secondParameter] = "0P";
            return true;
            //attack move for black from right side
        } else if (board[firstParameter - 1][secondParameter + 1].equals("0P")  && !isWhite &&
                String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("1")) {
            board[firstParameter - 1][secondParameter + 1] = "..";
            board[firstParameter][secondParameter] = "0P";
            return true;
        }
        //normal move for white
        if (board[firstParameter + 1][secondParameter].equals("1P") && isWhite &&
                board[firstParameter][secondParameter].equals("..")) {
            board[firstParameter + 1][secondParameter] = "..";
            board[firstParameter][secondParameter] = "1P";
            return true;
            //attack move for white from left side
        }else if (board[firstParameter + 1][secondParameter - 1].equals("1P")  && isWhite &&
                String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("0")) {
            board[firstParameter + 1][secondParameter - 1] = "..";
            board[firstParameter][secondParameter] = "1P";
            return true;
            //attack move for white from right side
        }else if (board[firstParameter + 1][secondParameter + 1].equals("1P")  && isWhite &&
                String.valueOf(board[firstParameter][secondParameter].charAt(0)).equals("1")) {
            board[firstParameter - 1][secondParameter + 1] = "..";
            board[firstParameter][secondParameter] = "0P";
            return true;
        }
        //attack move

        return  false;
    }
}

