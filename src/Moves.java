public class Moves {


    /*
    Board looks like:
      |
      |
      |
    a |
      |
      |
      |
      |_ _ _ _ _ _ _ _
                b
     */

    void possibleMoveForPawn(int[][] board, int actualA, int actualB, int newA, int newB) {
        //ruch na wprost

        if (actualA == 2) {

        }

        if (actualA + 1 <= 8) {
            //possible móve zrób coś np. podświetl na zielono
        }
        //ruch na skos w prawo
        if (newA + 1 <= 8 && newB + 1 <= 8 && newA == (actualA + 1)) {
            //możliwy ruch
        }
        //ruch na skos w lewo
        if (newA + 1 <= 8 && newB - 1 <= 8 && newA == (actualA + 1)) {
            //możliwy ruch
        }
    }
}
