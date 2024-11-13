package homework_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DriverRepository driverRepository = new DriverRepository();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите действие:");
            System.out.println("1 - Добавить водителя");
            System.out.println("2 - Добавить шесть водителей");
            System.out.println("3 - Показать всех водителей");
            System.out.println("4 - Показать водителей старше определенного возраста");
            System.out.println("0 - Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    Driver driver = createDriver(scanner);
                    driverRepository.save(driver);
                    System.out.println("Водитель добавлен.");
                    break;

                case 2:

                    List<Driver> drivers = new ArrayList<>();
                    for (int i = 0; i < 6; i++) {
                        System.out.println("Введите данные для водителя #" + (i + 1) + ":");
                        drivers.add(createDriver(scanner));
                    }
                    driverRepository.saveSixDriver(drivers);
                    System.out.println("Шесть водителей добавлены.");
                    break;

                case 3:

                    List<Driver> allDrivers = driverRepository.getAll();
                    System.out.println("Список всех водителей:");
                    for (Driver d : allDrivers) {
                        System.out.println(d);
                    }
                    break;

                case 4:

                    System.out.print("Введите минимальный возраст: ");
                    int minAge = scanner.nextInt();
                    List<Driver> driversByAge = driverRepository.getAllByAge(minAge);
                    System.out.println("Водители старше " + minAge + " лет:");
                    for (Driver d : driversByAge) {
                        System.out.println(d);
                    }
                    break;

                case 0:

                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static Driver createDriver(Scanner scanner) {

        Driver driver = new Driver();
        System.out.print("Введите имя водителя: ");
        driver.setFirstName(scanner.nextLine());
        System.out.print("Введите фамилию водителя: ");
        driver.setLastName(scanner.nextLine());
        System.out.print("Введите возраст водителя: ");
        driver.setAge(scanner.nextInt());
        scanner.nextLine();
        return driver;

    }

}
