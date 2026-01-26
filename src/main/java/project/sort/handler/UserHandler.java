package project.sort.handler;

import lombok.experimental.UtilityClass;

import java.util.Scanner;

@UtilityClass
public class UserHandler {
    private static boolean isRunning = true;
    private static final Scanner sc = new Scanner(System.in);

    public static void run() {
        while (isRunning) {
            System.out.println("""
                    Это приложение поможет вам отсортировать данные.
                    Выберите, источник данных:
                    1 - Загрузить из файла
                    2 - Ввести вручную
                    3 - Заполнить случайным образом
                    4 - Выйти из приложения""");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> Action.enterFile(sc);
                case "2" -> Action.manualInput(sc);
                case "3" -> Action.generateData(sc);
                case "4" -> {
                    System.out.println("Завершаем программу.");
                    isRunning = false;
                }
                default -> System.out.println("Удостоверьтесь в правильности ввода.");
            }
            System.out.println();
        }
    }
}
