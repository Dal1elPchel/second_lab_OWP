import java.util.Scanner;
import java.util.NoSuchElementException;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            System.out.println("Вы в программе проверки десятичных шестизначных чисел " +
                    "без нулей в старших разрядах.\n" +
                    "Чтобы остановить программу, введите -1.\n" +
                    "Чтобы посмотреть список валидных, введите -2.\n");

            String userNum = "";
            while (true) {
                System.out.print("Введите число: ");
                userNum = scanner.nextLine();

                if (userNum.equals("-1")) break;

                if (userNum.equals("-2")) {
                    SixDigitNumber.print_all_valid();
                    continue;
                }
                checkNumber(userNum);
            }
            System.out.println("Вы вышли из программы.");
        }
        catch (NoSuchElementException ms) {
            System.out.println("Вы вышли из программы.");
        }
    }

    public void checkNumber(String number) {
        if (number.isEmpty()) {
            System.out.println("Ошибка! Пустая строка, чтобы программа работала корректно, введите число!");
            return;
        }

        SixDigitNumber sdn = new SixDigitNumber(number);
        sdn.check_currentNumber();
        SixDigitNumber.add_to_numbers(sdn);

        if (sdn.getChecked()) {
            System.out.println("Число валидное!");
        } else {
            System.out.println("Число не валидное! Оно должно быть шестизначным, без ведущих нулей.");
        }
    }
}

