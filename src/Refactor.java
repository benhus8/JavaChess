public class Refactor {
    public String refactorLetters(String movePosition) {
        char capital = Character.toUpperCase(movePosition.charAt(0));
        int asciiValue = (int) capital - 65;
        int secondParameter = (int) movePosition.charAt(1);
        return  (Integer.parseInt(String.valueOf(movePosition.charAt(1)))-1) + String.valueOf(asciiValue);
    }
}
