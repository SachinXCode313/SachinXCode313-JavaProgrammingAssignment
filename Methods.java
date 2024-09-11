/*
* This file consist Methods.
* 1.generateCombinations()
* 2.sumOfDigits()
* 3.findConsecutiveSums()
* 4.caesarCipher()
* 5.encodingNumberToAscii()
* */

package Assignment_4;
import Assignment_4.Constant;

public class Methods {
    static Assignment_4.Constant constant = new Constant();

    public static int CountConsonants(String input){
        char chars[] = input.toCharArray();
        int count = 0;
        boolean flag = true;
        char[] vowels = {'a','e','i','o','u',' '};
        for(int i=0;i<input.length();i++){
            for(int j=0;j<vowels.length;i++){
                if(chars[i] == vowels[j]){
                    flag = false;
                }
            }
            if(flag == true){
                count++;
            }
            flag=true;
        }
        return count;
    }

    /*
     * This method convert binary value to decimal value.
     * Input parameter : int
     * Output parameter : int
     */
    public static int binaryToDecimal(int BinaryValue, int count) {
        if (BinaryValue == 0) {
            return 0;
        } else {
            int lastDigit = BinaryValue % 10;
            int remainingDigitsDecimal = binaryToDecimal(BinaryValue / 10, count + 1);
            return lastDigit * (int) Math.pow(2, count) + remainingDigitsDecimal;
        }
    }




}
