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
            String operation = "";
            String fromBase = "";
            String number1 = "";
            String toBase = "";
            String number2 = "";
            if (parts.length == 5 || (parts[0].equalsIgnoreCase("convert") || parts[0].equalsIgnoreCase("add") || parts[0].equalsIgnoreCase("sub")) || parts[3].equalsIgnoreCase("to")) {
                if (parts[0].equalsIgnoreCase("convert")) {
                    operation = parts[0];
                    fromBase = parts[1].toLowerCase();
                    number1 = parts[2];
                    toBase = parts[4].toLowerCase();
                }

                if (parts[0].equalsIgnoreCase("add") || parts[0].equalsIgnoreCase("sub")) {
                    operation = parts[0];
                    fromBase = parts[1].toLowerCase();
                    number1 = parts[2];
                    toBase = parts[3].toLowerCase();
                    number2 = parts[4];
                }
            } else {
                System.out.println(constant.INVALID_INPUT_MESSAGE);
                continue;
            }


            try {
                String result = "";
                switch (operation + fromBase + "to" + toBase) {
                    case "convertbinarytodecimal":
                        result = String.valueOf(NumberSystemConverter.binaryToDecimal(number1));
                        break;
                    case "convertbinarytooctal":
                        result = NumberSystemConverter.binaryToOctal(number1);
                        break;
                    case "convertbinarytohexadecimal":
                        result = NumberSystemConverter.binaryToHex(number1);
                        break;

                    case "convertoctaltodecimal":
                        result = String.valueOf(NumberSystemConverter.octalToDecimal(number1));
                        break;
                    case "convertoctaltobinary":
                        result = NumberSystemConverter.octalToBinary(number1);
                        break;
                    case "convertoctaltohexadecimal":
                        result = NumberSystemConverter.octalToHex(number1);
                        break;

                    case "converthexadecimaltodecimal":
                        result = String.valueOf(NumberSystemConverter.hexToDecimal(number1.toUpperCase()));
                        break;
                    case "converthexadecimaltobinary":
                        result = NumberSystemConverter.hexToBinary(number1.toUpperCase());
                        break;
                    case "converthexadecimaltooctal":
                        result = NumberSystemConverter.hexToOctal(number1.toUpperCase());
                        break;

                    case "convertdecimaltobinary":
                        result = NumberSystemConverter.decimalToBinary(Integer.parseInt(number1));
                        break;
                    case "convertdecimaltooctal":
                        result = NumberSystemConverter.decimalToOctal(Integer.parseInt(number1));
                        break;
                    case "convertdecimaltohexadecimal":
                        result = NumberSystemConverter.decimalToHex(Integer.parseInt(number1));
                        break;


                    case "addbinarytodecimal":
                        result = String.valueOf(NumberSystemConverter.addBinaryToDecimal(number1, number2));
                        break;
                    case "addbinarytooctal":
                        result = NumberSystemConverter.addBinaryToOctal(number1, number2);
                        break;
                    case "addbinarytohexadecimal":
                        result = NumberSystemConverter.addBinaryToHex(number1, number2.toUpperCase());
                        break;

                    case "addoctaltodecimal":
                        result = String.valueOf(NumberSystemConverter.addOctalToDecimal(number1, number2));
                        break;
                    case "addoctaltobinary":
                        result = NumberSystemConverter.addOctalToBinary(number1, number2);
                        break;
                    case "addoctaltohexadecimal":
                        result = NumberSystemConverter.addOctalToHex(number1, number2.toUpperCase());
                        break;

                    case "addhexadecimaltodecimal":
                        result = String.valueOf(NumberSystemConverter.addHexToDecimal(number1.toUpperCase(), number2));
                        break;
                    case "addhexadecimaltobinary":
                        result = NumberSystemConverter.addHexToBinary(number1.toUpperCase(), number2);
                        break;
                    case "addhexadecimaltooctal":
                        result = NumberSystemConverter.addHexToOctal(number1.toUpperCase(), number2);
                        break;

                    case "adddecimaltobinary":
                        result = NumberSystemConverter.addDecimalToBinary(Integer.parseInt(number1), number2);
                        break;
                    case "adddecimaltooctal":
                        result = NumberSystemConverter.addDecimalToOctal(Integer.parseInt(number1), number2);
                        break;
                    case "adddecimaltohexadecimal":
                        result = NumberSystemConverter.addDecimalToHex(Integer.parseInt(number1), number2);
                        break;


                    case "subbinarytodecimal":
                        result = String.valueOf(NumberSystemConverter.subBinaryToDecimal(number1, Integer.parseInt(number2)));
                        break;
                    case "subbinarytooctal":
                        result = NumberSystemConverter.subBinaryToOctal(number1, number2);
                        break;
                    case "subbinarytohexadecimal":
                        result = NumberSystemConverter.subBinaryToHex(number1, number2);
                        break;

                    case "suboctaltodecimal":
                        result = String.valueOf(NumberSystemConverter.subOctalToDecimal(number1, Integer.parseInt(number2)));
                        break;
                    case "suboctaltobinary":
                        result = NumberSystemConverter.subOctalToBinary(number1, number2);
                        break;
                    case "suboctaltohexadecimal":
                        result = NumberSystemConverter.subOctalToHex(number1, number2);
                        break;

                    case "subhexadecimaltodecimal":
                        result = String.valueOf(NumberSystemConverter.subHexToDecimal(number1.toUpperCase(), Integer.parseInt(number2)));
                        break;
                    case "subhexadecimaltobinary":
                        result = NumberSystemConverter.subHexToBinary(number1.toUpperCase(), number2);
                        break;
                    case "subhexadecimaltooctal":
                        result = NumberSystemConverter.subHexToOctal(number1.toUpperCase(), number2);
                        break;

                    case "subdecimaltobinary":
                        result = NumberSystemConverter.subDecimalToBinary(number1, number2);
                        break;
                    case "subdecimaltooctal":
                        result = NumberSystemConverter.subDecimalToOctal(number1, number2);
                        break;
                    case "subdecimaltohexadecimal":
                        result = NumberSystemConverter.subDecimalToHex(number1, number2);
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
