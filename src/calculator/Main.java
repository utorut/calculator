package calculator;

import java.util.Scanner;

public class Main {

    private static Scanner in; // переменная для ввода строки
    private static String line; // переменная для хранения строки
    private static String[] lineArray; // массив для хранения элементов строки

    private static int num1; // переменная для хранения первого операнда
    private static int num2; // переменная для хранения второго операнда
    private static char operation; // переменная для хранения операции

    public static void main(String[] args) {

        System.out.println("Пожалуйста, введите число от 1(I) до 10(X)!");

        in = new Scanner(System.in); // вводим числа
        line = in.nextLine(); // записываем числа в переменную

        go(line);
    }

    public static void go(String line) {

        lineArray = line.split(" ");

        try {
            if (line.contains("I") || line.contains("V") || line.contains("X")) {

                num1 = Convert.convertRomanToInt(lineArray[0]); // конвертируем первый операнд
                num2 = Convert.convertRomanToInt(lineArray[2]); // конвертируем второй операнд
                operation = lineArray[1].charAt(0);

                if (num1 < 11 && num1 > 0 && num2 < 11 && num2 > 0) {

                    // считаем арабские числа и конвертируем их обратно в римские
                    String result = Convert.convertIntToRoman(Calculator.calc(num1, num2, operation));

                    System.out.println(result); // выводим результат на экран

                } else {

                    throw new NumberFormatException();
                }

            } else {

                num1 = Integer.parseInt(lineArray[0]);
                num2 = Integer.parseInt(lineArray[2]);
                operation = lineArray[1].charAt(0);

                if (num1 < 11 && num1 > 0 && num2 < 11 && num2 > 0) {

                    System.out.println(Calculator.calc(num1, num2, operation)); // считаем и выводим результат на экран
                } else {

                    throw new NumberFormatException();
                }

            }
        } catch (NumberFormatException e) {

            System.out.println("Ошибка!");
            System.out.println("Неправильный формат ввода!");

        } catch (ArithmeticException e) {

            System.out.println("Данной операции не обнаружено!");
            System.out.println("Доступные операции: +, -, *, /");
        }
    }
}
