package project.sort.validator;

public class PasswordValidator implements Validator {
    @Override
    public boolean validate(String input) {
        if (input != null &&
                input.matches("^(?=.*[a-z])(?=.*[A-Z])[A-Za-z0-9!@#$%^&*()_+\\-=\\[\\]{}|;:,.<>?]{8,}$")) {
            return true;
        }
        System.out.println("Пароль должен состоять минимум из 8ми символов, " +
                "включать хотя бы одну маленькую и одну большую английскую букву.");
        return false;

    }
}
