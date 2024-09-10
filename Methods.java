/*
* This file consist Methods.
* 1.generateCombinations()
* 2.sumOfDigits()
* 3.findConsecutiveSums()
* 4.caesarCipher()
* 5.encodingNumberToAscii()
* */

package Assignment_3;
import java.util.HashSet;
import java.util.Set;

public class Methods {
    static Constant constant = new Constant();

    /*
    * This method generates all valid combinations of the string pairs of parentheses.
    * It takes the string as input and output the array of string.
    * */

    public static void generateCombinations(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                System.out.println(input.substring(i, j + 1));
            }
        }
    }

    /*
    * SumOfDigits Method to find the sum of the digit until the number is reduced to single digit.
    * It takes the number as input and return the number as result.
    */
    public static int sumOfDigits(int number) {
        if(number >= 0 && number <10){
            return number;
        }

        while (number >= 10) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }

    /*
     * FindConsecutiveSums Method  print all possible combinations of consecutive natural numbers that sum up to the given number.
     * It takes number as input and return the number as result.
    */
    public static String findConsecutiveSums(int number) {

        for (int n = 2; n * (n + 1) / 2 <= number; n++) {
            int numerator = number - (n * (n - 1)) / 2;
            if (numerator % n == 0) {
                int x = numerator / n;

                if (x > 0) {
                    for (int i = 0; i < n; i++) {
                        if (i > 0) System.out.print(" + ");
                        System.out.print(x + i);
                    }
                    System.out.println();
                }
            }
        }
        return "";
    }

    /*
    * This method implements the Caesar Cipher encryption technique.
    * The program take an input string and a shift pattern array.
    * return value is string
    */
    public static String caesarCipher(String input, int[] shiftPattern) {
        String result = "";
        int shiftIndex = 0;

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (character == ' ') {
                shiftIndex = (shiftIndex + shiftPattern.length) % shiftPattern.length;
                result += character;
            } else if (Character.isLetter(character)) {
                int shift = shiftPattern[shiftIndex];

                if (Character.isLowerCase(character)) {
                    char shiftedChar = (char) ('a' + (character - 'a' + shift + 26) % 26);
                    result += shiftedChar;
                } else if (Character.isUpperCase(character)) {
                    char shiftedChar = (char) ('A' + (character - 'A' + shift + 26) % 26);
                    result += shiftedChar;
                }

                shiftIndex = (shiftIndex + 1) % shiftPattern.length;
            } else {
                result += character;
            }
        }
        return result;
    }

    /*
    * It encodes the highest digits, based on the provided series, into their corresponding ASCII characters.
    * It takes a array and series.
    * return value is string.
    */
    public static String encodingNumberToAscii(int[] array, int[] series) {
        String EncodedValue = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < series.length; i++) {
            if (series[i] > array.length) {
                System.out.println(constant.InvalidIndex);
            } else {
                    EncodedValue += (array[series[i] - 1] + 48);
            }
        }
            return EncodedValue;
    }

}
