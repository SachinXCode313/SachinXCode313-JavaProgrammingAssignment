/*
 * This is the main file where all methods and constant are called.
 * Created By : Sachin Gupta
 * Created Date : 11/9/2024
 */

package NumberSystem;

import NumberSystem.Constant;

import java.util.Scanner;

public class NumberSystemApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Constant constant = new Constant();
        String input;

        do {
            System.out.println(constant.INPUT_MESSAGE);
            input = scanner.nextLine();

            if (input.equalsIgnoreCase(constant.EXIT)) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 5 || !parts[0].equalsIgnoreCase("convert") || !parts[3].equalsIgnoreCase("to")) {
                System.out.println(constant.INVALID_INPUT_MESSAGE);

                continue;
            }

            String fromBase = parts[1].toLowerCase();
            String number = parts[2];
            String toBase = parts[4].toLowerCase();

            try {
                String result = "";

                // Handle conversions from one base to another
                switch (fromBase + "to" + toBase) {
                    case "binarytodecimal":
                        result = String.valueOf(NumberSystemConverter.binaryToDecimal(number));
                        break;
                    case "binarytooctal":
                        result = NumberSystemConverter.binaryToOctal(number);
                        break;
                    case "binarytohexadecimal":
                        result = NumberSystemConverter.binaryToHex(number);
                        break;

                    case "octaltodecimal":
                        result = String.valueOf(NumberSystemConverter.octalToDecimal(number));
                        break;
                    case "octaltobinary":
                        result = NumberSystemConverter.octalToBinary(number);
                        break;
                    case "octaltohexadecimal":
                        result = NumberSystemConverter.octalToHex(number);
                        break;

                    case "hexadecimaltodecimal":
                        result = String.valueOf(NumberSystemConverter.hexToDecimal(number.toUpperCase()));
                        break;
                    case "hexadecimaltobinary":
                        result = NumberSystemConverter.hexToBinary(number.toUpperCase());
                        break;
                    case "hexadecimaltooctal":
                        result = NumberSystemConverter.hexToOctal(number.toUpperCase());
                        break;

                    case "decimaltobinary":
                        result = NumberSystemConverter.decimalToBinary(Integer.parseInt(number));
                        break;
                    case "decimaltooctal":
                        result = NumberSystemConverter.decimalToOctal(Integer.parseInt(number));
                        break;
                    case "decimaltohexadecimal":
                        result = NumberSystemConverter.decimalToHex(Integer.parseInt(number));
                        break;
                    default:
                        System.out.println("Unsupported conversion type from '" + fromBase + "' to '" + toBase + "'");
                        continue;
                }
                System.out.println(constant.CONVERSION_RESULT + result);
            } catch (NumberFormatException e) {
                System.out.println(constant.INVALID_NUMBER_FORMAT + fromBase);
            }

        } while (true);

        scanner.close();
    }
}
