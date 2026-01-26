package project.sort.validator;

public class EmailValidator implements Validator {
    @Override
    public boolean validate(String input) {
        if (input != null && input.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$")) {
            return true;
        }
        System.out.println("Проверьте правильность написания почты.");
        return false;
    }
}
