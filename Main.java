package Assignment_3;

import static Assignment_3.Methods.findConsecutiveSums;
import static Assignment_3.Methods.sumOfDigits;
import java.util.InputMismatchException;
import java.util.Scanner;
import

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Constant constant = new Constant();
        int choice = 0;

        do {
            try {
                System.out.println(constant.SelectTask);
                System.out.println(constant.Task1);
                System.out.println(constant.Task2);
                System.out.println(constant.Task3);
                System.out.println(constant.Task4);
                System.out.println(constant.Task5);
                System.out.println(constant.Exit);


                System.out.print(constant.Choice);
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print(constant.Progress);
                        break;
                    case 2:
                        System.out.print(constant.CheckPositive);
                        if (scanner.hasNextInt()) {
                            int number = scanner.nextInt();
                            if (number <= 0) {
                                System.out.print(constant.ErrorPositive);
                            } else {
                                int result = sumOfDigits(number);
                                System.out.println(constant.Task2Output + result);
                            }
                        } else {
                            System.out.print(constant.InvalidInputMessage);
                            scanner.next();
                        }
                        Thread.sleep(2000);
                        break;
                    case 3:
                        System.out.print(constant.CheckPositive);
                        if (scanner.hasNextInt()) {
                            int number = scanner.nextInt();
                            if (number <= 0) {
                                System.out.print(constant.ErrorPositive);
                            } else {
                                System.out.println(constant.Task3Output);
                                System.out.println(findConsecutiveSums(number));
                            }
                        } else {
                            System.out.print(constant.InvalidInputMessage);
                            scanner.next();
                        }
                        Thread.sleep(2000);
                        break;
                    case 4:
                        System.out.println(constant.Progress);
                        break;
                    case 5:
                        System.out.println(constant.Progress);
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

        } while (choice != 6);
    }
}
