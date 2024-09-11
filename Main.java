/*
 * This is the main file where all methods and constant are called.
 * Created By : Sachin Gupta
 * Date : 10/9/2024
 */

package Assignment_4;

import Assignment_4.Constant;
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

                switch (choice) {
                    case 1:

                        break;
                    case 2:
                        try{

                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }

                        break;
                    case 3:
                        try {

                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }
                        break;
                    case 4:
                        try{
                            int result = CountConsonants("Hello World");
                            System.out.println(result);
                        }
                        catch (Exception e) {
                            System.out.println(constant.InvalidInput);
                        }
                        break;
                    case 5:
                        try{
                            int BinaryValue = scanner.nextInt();
                            int  DecimalValue = binaryToDecimal(BinaryValue,0);
                            System.out.println(DecimalValue);
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
