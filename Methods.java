/*
 * This file consist Methods.
 * 1.countUniquePalindromes()
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
     * helper method check the input string is palindrome or not.
     * Input parameter : string input , start , end
     * Output parameter :boolean
     */
    private static boolean isPalindrome(String input, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }
        return isPalindrome(input, start + 1, end - 1);
    }

    /* helper method to find palindrome substrings and count unique ones.
     * Input parameter : String input, start 0 , end 0 , string array , count 0
     * Output parameter : int
     */
    private static int countPalindromicSubstrings(String input, int start, int end, String[] palindromes, int count) {
        if (start >= input.length()) {
            return count;
        }
        if (end >= input.length()) {
            return countPalindromicSubstrings(input, start + 1, start + 1, palindromes, count);
        }
        if (isPalindrome(input, start, end)) {
            String substring = input.substring(start, end + 1);
            if (!isAlreadyCounted(palindromes, count, substring)) {
                palindromes[count] = substring;
                count++;
            }
        }
        return countPalindromicSubstrings(input, start, end + 1, palindromes, count);
    }

    /* Helper method to check if a substring is already counted.
     * Input parameter : String array , count , substring
     * Output parameter : boolean
     */
    private static boolean isAlreadyCounted(String[] palindromes, int count, String substring) {
        if (count == 0) {
            return false;
        }
        if (palindromes[count - 1].equals(substring)) {
            return true;
        }
        return isAlreadyCounted(palindromes, count - 1, substring);
    }

    /*
     * This method count the number of unique palindromes.
     * Input parameter : String
     * Output parameter :BigInteger
     */
    public static int countUniquePalindrome(String input) {
        String[] palindromes = new String[input.length() * (input.length() + 1) / 2];
        return countPalindromicSubstrings(input, 0, 0, palindromes, 0);
    }

    /*
     * This method find the nth number in fibonacci series.
     * Input parameter : index 0 , input number , prev1 0 , prev2 1
     * Output parameter :BigInteger
     */
    public static BigInteger findNthFibonacci(int index, int number, BigInteger prev1, BigInteger prev2) {
        if (index == number) {
            return prev1;
        }
        return findNthFibonacci(index + 1, number, prev1.add(prev2), prev1);
    }

    /*
     * This method convert the snake case string to camel case string.
     * Input parameter : string input , index 0 , string "" , false
     * Output parameter :string
     */
    public static String snakeToCamel(String input, int index, String empty, boolean isFirstCharacter) {
        if (input == null || input.isEmpty() || index >= input.length()) {
            return empty;
        }
        char currentCharacter = input.charAt(index);
        if (currentCharacter == ' ' || currentCharacter == '_') {
            return snakeToCamel(input, index + 1, empty, isFirstCharacter);
        }
        if (isFirstCharacter) {
            empty += Character.toLowerCase(currentCharacter);
            return snakeToCamel(input, index + 1, empty, false);
        }
        if (index > 0 && (input.charAt(index - 1) == ' ' || input.charAt(index - 1) == '_')) {
            empty += Character.toUpperCase(currentCharacter);
        } else {
            empty += Character.toLowerCase(currentCharacter);
        }
        return snakeToCamel(input, index + 1, empty, false);
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
     * Input parameter : long , count
     * Output parameter : long
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





