/*
 * This is the method file where methods are perform some operations.
 * Created By : Sachin Gupta
 * Created Date : 25/9/2024
 */

package NumberSystem;

public class NumberSystemConverter {
    static Constant constant = new Constant();

    // Validate binary input
    public static boolean isValidBinary(String binary) {
        return binary.matches("[01]+");
    }

    // Validate octal input
    public static boolean isValidOctal(String octal) {
        return octal.matches("[0-7]+");
    }

    // Validate hexadecimal input
    public static boolean isValidHex(String hex) {
        return hex.matches("[0-9A-Fa-f]+");
    }

    // Convert from binary to decimal
    public static int binaryToDecimal(String binary) {
        if (!isValidBinary(binary)) {
            System.out.println(constant.INVALID_BINARY + binary);
        }
        int decimal = 0;
        int base = 1; // 2^0
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                decimal += base;
            }
            base *= 2;
        }
        return decimal;
    }

    // Convert from octal to decimal
    public static int octalToDecimal(String octal) {
        if (!isValidOctal(octal)) {
            System.out.println(constant.INVALID_OCTAL + octal);
        }
        int decimal = 0;
        int base = 1; // 8^0
        for (int i = octal.length() - 1; i >= 0; i--) {
            decimal += (octal.charAt(i) - '0') * base;
            base *= 8;
        }
        return decimal;
    }

    // Convert from hexadecimal to decimal
    public static int hexToDecimal(String hex) {
        if (!isValidHex(hex)) {
            System.out.println(constant.INVALID_HEXADECIMAL + hex);
        }
        int decimal = 0;
        int base = 1; // 16^0
        for (int i = hex.length() - 1; i >= 0; i--) {
            char digit = hex.charAt(i);
            if (digit >= '0' && digit <= '9') {
                decimal += (digit - '0') * base;
            } else if (digit >= 'A' && digit <= 'F') {
                decimal += (digit - 'A' + 10) * base;
            }
            base *= 16;
        }
        return decimal;
    }

    // Convert from decimal to binary (without StringBuilder)
    public static String decimalToBinary(int decimal) {
        String binary = "";
        while (decimal > 0) {
            binary = (decimal % 2) + binary;
            decimal /= 2;
        }
        return binary.isEmpty() ? "0" : binary;
    }

    // Convert from decimal to octal
    public static String decimalToOctal(int decimal) {
        String octal = "";
        while (decimal > 0) {
            octal = (decimal % 8) + octal;
            decimal /= 8;
        }
        return octal.isEmpty() ? "0" : octal;
    }

    // Convert from decimal to hexadecimal
    public static String decimalToHex(int decimal) {
        String hex = "";
        while (decimal > 0) {
            int remainder = decimal % 16;
            if (remainder < 10) {
                hex = remainder + hex;
            } else {
                hex = (char) (remainder - 10 + 'A') + hex;
            }
            decimal /= 16;
        }
        return hex.isEmpty() ? "0" : hex;
    }

    // Convert from binary to octal
    public static String binaryToOctal(String binary) {
        int decimal = binaryToDecimal(binary);
        return decimalToOctal(decimal);
    }

    // Convert from binary to hexadecimal
    public static String binaryToHex(String binary) {
        int decimal = binaryToDecimal(binary);
        return decimalToHex(decimal);
    }

    // Convert from octal to binary
    public static String octalToBinary(String octal) {
        int decimal = octalToDecimal(octal);
        return decimalToBinary(decimal);
    }

    // Convert from octal to hexadecimal
    public static String octalToHex(String octal) {
        int decimal = octalToDecimal(octal);
        return decimalToHex(decimal);
    }

    // Convert from hexadecimal to binary
    public static String hexToBinary(String hex) {
        int decimal = hexToDecimal(hex);
        return decimalToBinary(decimal);
    }

    // Convert from hexadecimal to octal
    public static String hexToOctal(String hex) {
        int decimal = hexToDecimal(hex);
        return decimalToOctal(decimal);
    }
}
