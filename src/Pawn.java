public class Pawn implements Chessman {
    @Override
    public void makeMove(String position, String[][] board, Boolean isWhite) {

        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));
        System.out.println(String.valueOf(firstParameter) + String.valueOf(secondParameter));

        //special 2 fields forward move for White!
        if (firstParameter == 4 && isWhite && board[6][secondParameter].equals("1P")) {
                board[4][secondParameter] = "1P";
                board[6][secondParameter] = "..";
        }
        //special 2 fields forward move for Black!
        if (firstParameter == 3 && !isWhite && board[1][secondParameter].equals("0P")) {
                board[3][secondParameter] = "0P";
                board[1][secondParameter] = "..";
            }
        //normal move for black
        if(board[firstParameter - 1][secondParameter].equals("0P") && !isWhite &&
        board[firstParameter][secondParameter].equals("..")) {
            board[firstParameter - 1][secondParameter] = "..";
            board[firstParameter][secondParameter] = "0P";
        }
        //normal move for white
        if(board[firstParameter + 1][secondParameter].equals("1P") && isWhite &&
                board[firstParameter][secondParameter].equals("..")) {
            board[firstParameter + 1][secondParameter] = "..";
            board[firstParameter][secondParameter] = "1P";
        }

        }
    }

