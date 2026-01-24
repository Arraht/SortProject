package project.sort;

public class HappyUnhappyValidator {

    public static String validateUserInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "invalid";
        }

        String cleanedInput = input.trim().toLowerCase();

        // Множество допустимых значений для "happy"
        Set<String> happySet = Set.of(
                "happy", "h", "yes", "y", "да", "д", "+", "1",
                "good", "great", "awesome", "рад", "доволен"
        );

        // Множество допустимых значений для "unhappy"
        Set<String> unhappySet = Set.of(
                "unhappy", "u", "no", "n", "нет", "н", "-", "0",
                "bad", "sad", "poor", "недоволен", "грустно"
        );

        if (happySet.contains(cleanedInput)) {
            return "happy";
        } else if (unhappySet.contains(cleanedInput)) {
            return "unhappy";
        } else {
            return "invalid";
        }
}
