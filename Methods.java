/*
 * This file consist Methods.
 * 1.countPalindromes()
 * 2.findNthFibonacci()
 * 3.snakeToCamel()
 * 4.countConsonants()
 * 5.binaryToDecimal()
 * Created By : Sachin Gupta
 * Created Date : 11/9/2024
 */

package Assignment_4;

import java.math.BigInteger;

public class Methods {
    /*
     * This method find the nth number in fibonacci series.
     * Input parameter : int
     * Output parameter :int
     */
    public static BigInteger findNthFibonacci(int index, int number, BigInteger prev1, BigInteger prev2) {
        if (index == number) {
            return prev1;
        }
        return findNthFibonacci(index + 1, number, prev1.add(prev2), prev1);
    }

    /*
     * This method convert the snake case string to camel case string.
     * Input parameter : string & string length
     * Output parameter :string
     */
    public static String snakeToCamel(String input, int index, String empty) {
        input = input.trim().replace('_', ' ');
        if (input == null || input.isEmpty() || index >= input.length()) {
            return empty;
        }
        char currentCharacter = input.charAt(index);
        if (currentCharacter == ' ' || currentCharacter == '_') {
            if (index + 1 < input.length() && Character.isLetter(input.charAt(index + 1))) {
                empty += Character.toUpperCase(input.charAt(index + 1));
                return snakeToCamel(input, index + 2, empty);
            }
        } else {
            empty += Character.toLowerCase(currentCharacter);
        }
        return snakeToCamel(input, index + 1, empty);
    }

    /*
     * This method count the number of Consonants.
     * Input parameter : string & string length
     * Output parameter : int
     */
    public static int countConsonants(String input, int inputLength) {
        if (input == null || input.isEmpty() || inputLength == 0) {
            return 0;
        }
        char firstChar = Character.toLowerCase(input.charAt(input.length() - inputLength));
        if (Character.isLetter(firstChar) && firstChar != 'a' && firstChar != 'e' && firstChar != 'i' && firstChar != 'o' && firstChar != 'u') {
            return 1 + countConsonants(input, inputLength - 1);
        } else {
            return countConsonants(input, inputLength - 1);
        }
    }

    /*
     * This method convert binary value to decimal value.
     * Input parameter : int
     * Output parameter : int
     */
    public static long binaryToDecimal(long BinaryValue, int count) {
        if (BinaryValue == 0) {
            return 0;
        } else {
            long lastDigit = BinaryValue % 10;
            long remainingDigitsDecimal = binaryToDecimal(BinaryValue / 10, count + 1);
            return lastDigit * (int) Math.pow(2, count) + remainingDigitsDecimal;
        }
    }
}




