import java.util.Arrays;

public class GameRules {
    public Boolean isCheck(String[][] board, Boolean isWhite) {
        String kingPosition = "";
        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        String colorId;
        if (isWhite) {
            colorId = "1";
        } else colorId = "0";

        //find King
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(colorId + "K")) {
                    kingPosition = String.valueOf(i) + String.valueOf(j);
                }
            }
        }
        //is something ATTACKING MY KING! == is !isWhite attacking king!
        return attackOnField(board, isWhite, kingPosition).getPossibility();

    }

    public Boolean isCheckMate(String[][] board, Boolean isWhite) {
        Pawn pawn = new Pawn();
        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        King king = new King();
        int firstParameterKing = 0;
        int secondParameterKing = 0;
        String colorId;
        String enemyColorId;
        if (isWhite) {
            colorId = "1";
            enemyColorId = "0";
        } else {
            colorId = "0";
            enemyColorId = "1";
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].equals(colorId + "K")) {
                    firstParameterKing = i;
                    secondParameterKing = j;
                }
            }
        }
        //if king move anywhere
        if (secondParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (firstParameterKing + 1 < 8 && secondParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }

        if (firstParameterKing + 1 < 8) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (firstParameterKing + 1 < 8 && secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing + 1) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (firstParameterKing - 1 >= 0 && secondParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing - 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (firstParameterKing - 1 >= 0) {
            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility())
                return false;
        }
        if (firstParameterKing - 1 >= 0 && secondParameterKing + 1 < 8) {

            String newPosition = String.valueOf(firstParameterKing - 1) + String.valueOf(secondParameterKing + 1);
            if (king.makeMove(newPosition, board, isWhite, "K").getPossibility() && !attackOnField(board, isWhite, newPosition).getPossibility()) {
                return false;
            }
        }

        //if anything can kill the checking chessPiece
        String kingPosition = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing);
        AttackOnFieldResponse attackOnKing = attackOnField(board, isWhite, kingPosition);
        String attackingChessmanPosition = String.valueOf(attackOnKing.getFirstParameterAttackingChessman()) + String.valueOf(attackOnKing.getSecondParameterAttackingChessman());

        if (attackOnField(board, !isWhite, attackingChessmanPosition).getPossibility()) {
            return false;
        }
        //TODO: WAY
        //if any piece can cover the king
        int firstAttackingParameter = attackOnKing.getFirstParameterAttackingChessman();
        int secondAttackingParameter = attackOnKing.getSecondParameterAttackingChessman();

        if (String.valueOf(board[firstAttackingParameter][secondAttackingParameter].charAt(1)).equals("B") || String.valueOf(board[firstAttackingParameter][secondAttackingParameter].charAt(1)).equals("Q")) {
            //mean that the bishop is over right
            if (firstAttackingParameter < firstParameterKing && secondAttackingParameter > secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (firstParameterKing - i >= 0 && secondParameterKing + i < 8) {
                        String position = String.valueOf(firstParameterKing - i) + String.valueOf(secondParameterKing + i);
                        if (!(firstAttackingParameter == firstParameterKing - i && secondAttackingParameter == secondParameterKing + i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }

            //mean that the bishop is over left
            if (firstAttackingParameter < firstParameterKing && secondAttackingParameter < secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (firstParameterKing - i >= 0 && secondParameterKing - i >= 0) {
                        String position = String.valueOf(firstParameterKing - i) + String.valueOf(secondParameterKing - i);
                        if (!(firstAttackingParameter == firstParameterKing - i && secondAttackingParameter == secondParameterKing - i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }

            //mean that the bishop is bottom left
            if (firstAttackingParameter > firstParameterKing && secondAttackingParameter < secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (firstParameterKing + i < 8 && secondParameterKing - i >= 0) {
                        String position = String.valueOf(firstParameterKing + i) + String.valueOf(secondParameterKing - i);
                        if (!(firstAttackingParameter == firstParameterKing + i && secondAttackingParameter == secondParameterKing - i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }

            //mean that the bishop is bottom right
            if (firstAttackingParameter > firstParameterKing && secondAttackingParameter > secondParameterKing) {
                for (int i = 1; i < 8; i++) {
                    if (firstParameterKing + i < 8 && secondParameterKing + i < 8) {
                        String position = String.valueOf(firstParameterKing + i) + String.valueOf(secondParameterKing + i);
                        if (!(firstAttackingParameter == firstParameterKing + i && secondAttackingParameter == secondParameterKing + i)) {
                            if (simulateMove(position, board, isWhite)) {
                                return false;
                            }
                            ;
                        } else break;
                    }
                }
            }
        }

        //TODO: Rook way

        //Rook on the king left side
        if (String.valueOf(board[firstAttackingParameter][secondAttackingParameter].charAt(1)).equals("R") || String.valueOf(board[firstAttackingParameter][secondAttackingParameter].charAt(1)).equals("Q")) {
            if (firstAttackingParameter == firstParameterKing && secondAttackingParameter < secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (secondParameterKing - i >= 0) {
                        String position = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing - i);
                        if (!(secondAttackingParameter == secondParameterKing - i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }
            //Rook on the king right side
            if (firstAttackingParameter == firstParameterKing && secondAttackingParameter > secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (secondParameterKing + i < 8) {
                        String position = String.valueOf(firstParameterKing) + String.valueOf(secondParameterKing + i);
                        if (!(secondAttackingParameter == secondParameterKing + i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }
            // Rook is over the king
            if (firstAttackingParameter < firstParameterKing && secondAttackingParameter == secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (firstParameterKing - i >= 0) {
                        String position = String.valueOf(firstParameterKing - i) + String.valueOf(secondParameterKing);
                        if (!(firstAttackingParameter == firstParameterKing - i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }
            // Rook is over the king
            if (firstAttackingParameter > firstParameterKing && secondAttackingParameter == secondParameterKing) {
                for (int i = 0; i < 8; i++) {
                    if (firstParameterKing + i < 8) {
                        String position = String.valueOf(firstParameterKing + i) + String.valueOf(secondParameterKing);
                        if (!(firstAttackingParameter == firstParameterKing + i)) {
                            if (simulateMove(position, board, isWhite)) return false;
                        } else break;
                    }
                }
            }


        }

        return true;
    }

    private AttackOnFieldResponse attackOnField(String[][] board, Boolean isWhite, String position) {
        int firstParameter = Integer.parseInt(String.valueOf(position.charAt(0)));
        int secondParameter = Integer.parseInt(String.valueOf(position.charAt(1)));

        String[][] boardCopy = new String[board.length][];
        for (int i = 0; i < board.length; i++)
            boardCopy[i] = board[i].clone();

        String colorId;
        if (isWhite) {
            colorId = "0";
        } else {
            colorId = "1";
        }

        Rook rook = new Rook();
        Bishop bishop = new Bishop();
        Knight knight = new Knight();
        Queen queen = new Queen();
        MakeMoveResponse makeMove;

        makeMove = rook.makeMove(position, board, !isWhite, "R");
        if (makeMove.getPossibility()) {
            return new AttackOnFieldResponse(true, makeMove.getFirstParameterToClear(), makeMove.getSecondParameterToClear());
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (rook.makeMove(position, boardCopy, !isWhite, "R").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return new AttackOnFieldResponse(true, 0, 0);
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }

        makeMove = bishop.makeMove(position, board, !isWhite, "B");
        if (makeMove.getPossibility()) {
            return new AttackOnFieldResponse(true, makeMove.getFirstParameterToClear(), makeMove.getSecondParameterToClear());
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (bishop.makeMove(position, boardCopy, !isWhite, "B").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return new AttackOnFieldResponse(true, 0, 0);
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }

        makeMove = knight.makeMove(position, board, !isWhite, "N");
        if (makeMove.getPossibility()) {
            return new AttackOnFieldResponse(true, makeMove.getFirstParameterToClear(), makeMove.getSecondParameterToClear());
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (knight.makeMove(position, boardCopy, !isWhite, "N").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return new AttackOnFieldResponse(true, 0, 0);
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }

        makeMove = queen.makeMove(position, board, !isWhite, "Q");
        if (makeMove.getPossibility()) {
            return new AttackOnFieldResponse(true, makeMove.getFirstParameterToClear(), makeMove.getSecondParameterToClear());
        } else if (board[firstParameter][secondParameter].startsWith(colorId)) {
            boardCopy[firstParameter][secondParameter] = "..";
            if (queen.makeMove(position, boardCopy, !isWhite, "Q").getPossibility()) {
                boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
                return new AttackOnFieldResponse(true, 0, 0);
            } else boardCopy[firstParameter][secondParameter] = board[firstParameter][secondParameter];
        }
        if (!isWhite) {
            if (firstParameter + 1 < 8 && secondParameter - 1 >= 0 && board[firstParameter + 1][secondParameter - 1].equals("1P")) {
                return new AttackOnFieldResponse(true, firstParameter + 1, secondParameter - 1);
            }
            if (firstParameter + 1 < 8 && secondParameter + 1 < 8 && board[firstParameter + 1][secondParameter + 1].equals("1P")) {
                return new AttackOnFieldResponse(true, firstParameter + 1, secondParameter + 1);
            }
        } else {
            if (firstParameter - 1 >= 0 && secondParameter - 1 >= 0 && board[firstParameter - 1][secondParameter - 1].equals("0P"))
                return new AttackOnFieldResponse(true, firstParameter - 1, secondParameter - 1);

            if (firstParameter - 1 >= 0 && secondParameter + 1 < 8 && board[firstParameter - 1][secondParameter + 1].equals("0P")) {
                return new AttackOnFieldResponse(true, firstParameter - 1, secondParameter + 1);
            }
        }

        return new AttackOnFieldResponse(false, -1, -1);
    }

    private Boolean simulateMove(String position, String[][] board, Boolean isWhite) {
        if (App.pawn.makeMove(position, board, isWhite, "P").getPossibility()) return true;
        if (App.rook.makeMove(position, board, isWhite, "R").getPossibility()) return true;
        if (App.knight.makeMove(position, board, isWhite, "N").getPossibility()) return true;
        if (App.bishop.makeMove(position, board, isWhite, "B").getPossibility()) return true;
        if (App.queen.makeMove(position, board, isWhite, "Q").getPossibility()) return true;
        return false;
    }
}

