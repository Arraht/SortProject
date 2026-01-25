package project.sort.validator;

public class PasswordValidator implements Validator {
    @Override
    public boolean validate(String input) {
        return input != null &&
                input.matches("^(?=.*[a-z])(?=.*[A-Z])[A-Za-z0-9!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?]{8,}$");
    }
}
