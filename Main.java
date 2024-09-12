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
                    case 1:
                        System.out.println(constant.Progress);
                        break;
                    case 2:
                        while (repeatAction) {
                            try {
                                if (scanner.hasNextInt()) {
                                    int number = scanner.nextInt();
                                    BigInteger result = findNthFibonacci(0, number, BigInteger.ZERO, BigInteger.ONE);
                                    System.out.println(result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    case 3:
                        while (repeatAction) {
                            try {
                                if (scanner.hasNextLine()) {
                                    scanner.nextLine();
                                    String input = scanner.nextLine();
                                    String result = snakeToCamel(input, 0, "");
                                    System.out.println(result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    case 4:
                        while (repeatAction) {
                            try {
                                if (scanner.hasNextLine()) {
                                    scanner.nextLine();
                                    String input = scanner.nextLine();
                                    int result = countConsonants(input, input.length());
                                    System.out.println(result);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
                    case 5:

                        while (repeatAction) {
                            try {
                                if (scanner.hasNextLong()) {
                                    long BinaryValue = scanner.nextLong();
                                    long DecimalValue = binaryToDecimal(BinaryValue, 0);
                                    System.out.println(DecimalValue);
                                } else {
                                    System.out.println(constant.InvalidChoice);
                                    scanner.next();
                                }
                                System.out.println(constant.RepeatAction);
                                String repeat = scanner.next();
                                repeatAction = repeat.equalsIgnoreCase("Y");
                            } catch (Exception e) {
                                System.out.println(constant.InvalidInput);
                                scanner.next();
                            }
                        }
                        break;
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
