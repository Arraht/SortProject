package project.sort.validator;

public class NameValidator implements Validator {
    @Override
    public boolean validate(String input) {
        if (input != null && input.trim().length() >= 2 && input.matches("^[A-Za-zА-Яа-яЁё\\s]+$")) {
            return true;
        }
        System.out.println("Имя должно содержать больше 2 символов и состоять из русских или английский букв.");
        return false;
    }
}
