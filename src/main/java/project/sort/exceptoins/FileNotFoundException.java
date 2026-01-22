package project.sort.exceptoins;

public class FileNotFoundException extends RuntimeException {
  public FileNotFoundException(String message) {
    super(message);
  }
}