package calculator;

public class Calculator {

    private static int result;

    public static int calc(int num1, int num2, char operation) throws ArithmeticException {

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new ArithmeticException();
        }

        return result;
    }
}
