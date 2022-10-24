public class Refactor {
    public String refactorLetters(String movePosition) {
        char capital = Character.toUpperCase(movePosition.charAt(0));
        int asciiValue = (int) capital - 65;
        return String.valueOf(asciiValue) + movePosition.charAt(1);
    }
}
