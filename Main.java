/*
 * This is the main file where all methods and constant are called.
 * Created By : Sachin Gupta
 * Date : 10/9/2024
 */

package Assignment_3;
import static Assignment_3.Methods.generateCombinations;
import static Assignment_3.Methods.sumOfDigits;
import static Assignment_3.Methods.findConsecutiveSums;
import static Assignment_3.Methods.caesarCipher;
import static Assignment_3.Methods.encodingNumberToAscii;
import java.util.InputMismatchException;
import java.util.Scanner;

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
                        String input = scanner.nextLine();
                        generateCombinations(input);
                        break;
                    case 2:
                        try{
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
                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }


                        Thread.sleep(2000);
                        break;
                    case 3:
                        try {
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
                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }
                        Thread.sleep(2000);
                        break;
                    case 4:
                        try{
                            System.out.println(constant.StringInput);
                            String string = scanner.nextLine();
                            System.out.println(constant.ShiftLength);
                            int shiftLength = scanner.nextInt();
                            int[] shift = new int[shiftLength];
                            System.out.print(constant.ShiftValue);
                            for(int i=0;i<shiftLength;i++){
                                shift[i] = scanner.nextInt();
                            }
                            if(string.length()>=shiftLength){
                                String result = caesarCipher(string,shift);
                                System.out.println(result);
                            }
                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }
                        break;
                    case 5:
                        try{
                            System.out.print(constant.ArrayLength);
                            int arrayLength = scanner.nextInt();
                            int[] array = new int[arrayLength];
                            System.out.print(constant.ArrayValue);
                            for(int i=0;i<arrayLength;i++){
                                array[i] = scanner.nextInt();
                            }

                            System.out.print(constant.SeriesLength);
                            int seriesLength = scanner.nextInt();
                            int[] series = new int[seriesLength];
                            System.out.print(constant.SeriesValue);
                            for(int i=0;i<seriesLength;i++){
                                series[i] = scanner.nextInt();
                            }
                            if(arrayLength>=seriesLength){
                                String result = encodingNumberToAscii(array,series);
                                System.out.println(result);
                            }
                        } catch (Exception e) {
                            System.out.println(constant.InvalidInput);
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
