public interface Chessman {

    //return true when move is correct, false otherwise
    Boolean makeMove(String position, String[][] board, Boolean isWhite);
}
