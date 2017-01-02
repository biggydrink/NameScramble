/**
 * Created by Andrew on 1/1/2017.
 */

import java.util.Scanner;

public class NameScrambler {

    public static void main(String args[]) {

        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Enter your word: ");
        String word = stringScanner.nextLine().toLowerCase();

        //System.out.println(numbers(5)); // infinite loop
        iterativeAnagram(word);
    }

    static String recursiveAnagram(String word) {
        if (word.equals("")) {
            return word;
        } else {
            return word.charAt(0) + word.substring(1,word.length());
        }
    }

    // Attempting to simplify recursiveAnagram
    static String numbers(int num) {
        // infinite loop
        String result = "";
        if (num == 1) {
            result += 1;
        } else {
            result += num;
            for (int i = 0; i < num; ++i) {
                result += numbers(num - i);
            }

        }

        return result;
    }


    // each character needs to loop through all the other characters except the one it is
    static void iterativeAnagram(String combined) {

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
