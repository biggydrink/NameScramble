/**
 * Created by Andrew on 1/1/2017.
 */

import java.util.Scanner;

public class NameScrambler {

    public static void main(String args[]) {

        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Enter name 1: ");
        String name1 = stringScanner.nextLine().toLowerCase();
        System.out.print("Enter name 2: ");
        String name2 = stringScanner.nextLine().toLowerCase();

        String combined = name1 + name2;
        char[] name1Char = name1.toCharArray();
        char[] name2Char = name2.toCharArray();
        int combinedLength = name1.length() + name2.length();
        char[] combinedChar = combined.toCharArray();

        //tryOne(combined);
        //tryTwo(combined);
        //tryThree(combined);
        System.out.println(tryFour(combined));

    }



    static String tryFour(String combined) {
        if (combined.length() == 1) {
            return combined;
        } else {

            return tryFour(combined.substring(combined.length()-1));
        }
    }
    // each character needs to loop through all the other characters except the one it is

    static void tryThree(String combined) {

        String result;

        for (int i = 0; i < combined.length(); ++i) {
            result = "";
            result += combined.charAt(i);

            for (int j = 0; j < combined.length(); ++j) {
                if (j != i) {
                    result += combined.charAt(j);
                }

                for (int k = 0; k < combined.length(); ++k) {
                    if (k != j && k != i) {
                        result += combined.charAt(k);
                    }
                }
            }
        }

    }

    static void tryTwo(String combined) {

        String result;

        for (int i = 0; i < combined.length(); ++i) {
            result = "";
            result += combined.charAt(i);
            for (int j = 0 + i; j < combined.length(); ++j) {
                int newCounter = j;
                if (newCounter != i) {
                    result += combined.charAt(newCounter);
                }
                if (newCounter >= combined.length()) {
                    newCounter = 0;
                }
            }
            System.out.println(result);

        }
    }


    static void tryOne(String combined) {

        String result;
        char[] combinedChar = combined.toCharArray();

        for (int i = 0; i < combinedChar.length; ++i) {
            result = "";
            result += combinedChar[i];
            for (int j = combinedChar.length - 1; j > 0; --j) {
                result += combinedChar[j];
            }
            System.out.println(result);
        }
    }


}
