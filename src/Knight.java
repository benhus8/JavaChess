public class Knight implements Chessman {
    static final String knightId = "N";

    @Override
    public Boolean makeMove(String position, String[][] board, Boolean isWhite) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        String colorId;
        String enemyColorId;

        if (isWhite) {
            colorId = "1";
            enemyColorId = "0";
        } else {
            colorId = "0";
            enemyColorId = "1";
        }

        if (board[firstParameter][secondParameter].startsWith(enemyColorId) || board[firstParameter][secondParameter].equals("..")) {
            -2 +1
             -2 -1
             +2 +1 ELKI
             +2 +1

                //make move if true when not check next if
            }

        return false;
    }
}

