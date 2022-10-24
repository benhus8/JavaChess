public class Pawn implements Chessman {
    @Override
    public void makeMove(String position, String[][] board, Boolean isWhite) {

        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        //special 2 fields forward move for White!
        if (firstParameter == 4 && isWhite && board[6][secondParameter].equals("1P")) {
                board[4][secondParameter] = "1P";
                board[6][secondParameter] = "..";
        }
        //special 2 fields forward move for Black!
        if (firstParameter == 3 && !isWhite && board[1][secondParameter].equals("0P")) {
                board[3][secondParameter] = "1P";
                board[1][secondParameter] = "..";
            }
        //normal move

        }
    }

