package project.sort.validator;

public class EmailValidator implements Validator {
    @Override
    public boolean validate(String input) {
        return input != null && input.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}
