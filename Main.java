package Assignment_3;

import static Assignment_3.Methods.sumOfDigits;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();


        if (number <= 0) {
            System.out.println("The number must be a positive integer.");
            return;
        }
        if(number >= 0 && number <10){
            System.out.println("The single digit result iss: " + number);
            return;
        }

        while (number >= 10) {
            number = sumOfDigits(number);
        }

        // Output the result
        System.out.println("The single digit result is: " + number);
    }
}
