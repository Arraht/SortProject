package project.sort.validator;

public class NameValidator implements Validator {
    @Override
    public boolean validate(String input) {
        return input != null &&
                input.trim().length() >= 2 &&
                input.matches("^[A-Za-zА-Яа-яЁё]+$");
    }
}
