package Assignment_3;

public class Methods {
    public static int sumOfDigits(int number) {
        if(number >= 0 && number <10){
            return number;
        }

        while (number >= 10) {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            number = sum;
        }
        return number;
    }

    public static String findConsecutiveSums(int number) {

        for (int n = 2; n * (n + 1) / 2 <= number; n++) {
            int numerator = number - (n * (n - 1)) / 2;
            if (numerator % n == 0) {
                int x = numerator / n;

                if (x > 0) {
                    for (int i = 0; i < n; i++) {
                        if (i > 0) System.out.print(" + ");
                        System.out.print(x + i);
                    }
                    System.out.println();
                }
            }
        }
        return "";
    }

}
