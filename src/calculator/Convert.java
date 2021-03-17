package calculator;

public class Convert {

    private static int numbers[]  = new int[]{1, 4, 5, 9, 10, 50, 100, 500, 1000};
    private static String letters[]  = new String[]{ "I", "IV", "V", "IX", "X", "L", "C", "D", "M"};
    private static int last = 2000;

    private static int letterToNumber(char letter) {

        switch (letter) {
            case 'I':  return 1;
            case 'V':  return 5;
            case 'X':  return 10;
            case 'L':  return 50;
            case 'C':  return 100;
            case 'D':  return 500;
            case 'M':  return 1000;
            default:   return -1;
        }
    }

    public static int convertRomanToInt(String romaNum) throws NumberFormatException {

        int integerValue = 0;

        for (int i = 0; i < romaNum.length(); i++) {

            char ch = romaNum.charAt(i);
            int number = letterToNumber(ch);

            if (number == -1) {

                throw new NumberFormatException();
            }
            if(romaNum.contains("IX") || romaNum.contains("IV")) {

                number -= last + 1;
                integerValue += number;
                last = number;
            } else {

                integerValue += number;
            }
        }

        return integerValue;
    }

    public static String convertIntToRoman(int intNum) {

        String romanValue = "";

        if (intNum != 0) {
            while (intNum > 0) {

                for (int i = 0; i < numbers.length; i++) {

                    if (intNum < numbers[i]) {
                        intNum -= numbers[i - 1];
                        romanValue += letters[i - 1];
                        break;
                    }
                }
            }
        } else {

            throw new NumberFormatException();
        }


        return romanValue;
    }
}
