/*
 * This is the main file where all methods and constant are called.
 * Created By : Sachin Gupta
 * Created Date : 11/9/2024
 */

package Assignment_4;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.InputMismatchException;

import static Assignment_4.Methods.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Constant constant = new Constant();
        int choice = 0;

        do {
            try {
                System.out.println(constant.SelectOption);
                System.out.println(constant.Option1);
                System.out.println(constant.Option2);
                System.out.println(constant.Option3);
                System.out.println(constant.Option4);
                System.out.println(constant.Option5);
                System.out.println(constant.Exit);
                System.out.print(constant.Choice);
                choice = scanner.nextInt();
                boolean repeatAction = true;
                switch (choice) {
                    //This case perform countUniquePalindrome method.
                    case 1:
                        while (repeatAction) {
                            try {
                                System.out.print(constant.StringInput);
                                if (scanner.hasNextLine()) {
                                    scanner.nextLine();
                                    String input = scanner.nextLine();
                                    if (input.length() > 30) {
                                        System.out.println(constant.OutOfRangeError);
                                        continue;
                                    }
                                    int result = countUniquePalindrome(input);
                                    System.out.println(constant.PalindromeResult + result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }

                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    //This case perform findNthFibonacci method.
                    case 2:
                        while (repeatAction) {
                            try {
                                System.out.print(constant.NumberRangeInput);
                                if (scanner.hasNextInt()) {
                                    int number = scanner.nextInt();
                                    if (number > 10000) {
                                        System.out.println(constant.OutOfRangeError);
                                        continue;
                                    }
                                    BigInteger result = findNthFibonacci(0, number, BigInteger.ZERO, BigInteger.ONE);
                                    String numberAsString = result.toString();
                                    String shortNumber = numberAsString.length() > 15 ? numberAsString.substring(0, 15) + "..." : numberAsString;
                                    System.out.println(constant.FibonacciResult + shortNumber);
                                } else {
                                    System.out.println(constant.ErrorPositive);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    //This case perform snakeToCamel method.
                    case 3:
                        while (repeatAction) {
                            try {
                                System.out.print(constant.StringInput);
                                if (scanner.hasNextLine()) {
                                    scanner.nextLine();
                                    String input = scanner.nextLine();
                                    String result = snakeToCamel(input, 0, "", true);
                                    System.out.println(constant.CamelCaseResult + result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    //This case perform countConsonants method.
                    case 4:
                        while (repeatAction) {
                            try {
                                System.out.print(constant.StringInput);
                                if (scanner.hasNextLine()) {
                                    scanner.nextLine();
                                    String input = scanner.nextLine();
                                    int result = countConsonants(input, input.length());
                                    System.out.println(constant.ConsonantResult + result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    //This case perform binaryToDecimal method.
                    case 5:
                        while (repeatAction) {
                            try {
                                System.out.print(constant.NumberInput);
                                if (scanner.hasNextLong()) {
                                    long BinaryValue = scanner.nextLong();
                                    long DecimalValue = binaryToDecimal(BinaryValue, 0);
                                    System.out.println(constant.DecimalResult + DecimalValue);
                                } else {
                                    System.out.println(constant.OutOfRangeError);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y") || repeat.equalsIgnoreCase("Yes");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    //This case perform Exiting method.
                    case 6:
                        System.out.println(constant.Exiting);
                        break;
                    default:
                        System.out.println(constant.InvalidChoice);
                }
            } catch (InputMismatchException e) {
                System.out.println(constant.InvalidChoice);
                scanner.next();
            }

        }
        while (choice != 6);
    }
}
