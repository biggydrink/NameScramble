/**
 * Created by Andrew on 1/1/2017.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class NameScrambler {

    public static void main(String args[]) {

        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Enter your word: ");
        String word = stringScanner.nextLine().toLowerCase();

        //System.out.println(numbers(5)); // infinite loop
        //iterativeAnagram(word);
        //recursiveAnagram(word);

        ArrayList<String> anagrams = new ArrayList<>();
        anagrams = webRecursiveAnagrams(word);
        for (int i = 0; i < anagrams.size(); ++i) {
            System.out.println(anagrams.get(i));
        }
        System.out.println("Size: " + anagrams.size());

        stringScanner.close();
    }

    // Rewrite of a javascript program found at
    // http://math.stackexchange.com/questions/876352/how-can-i-calculate-the-total-number-of-possible-anagrams-for-a-set-of-letters
    static ArrayList<String> webRecursiveAnagrams(String word) {
        ArrayList<String> generatedAnagrams = new ArrayList<>();

        if (word.length() < 2) {
            generatedAnagrams.add(word);
            return generatedAnagrams;

        } else {
            String before, focus, after, newEntry, shortWord;
            ArrayList<String> subGeneratedAnagrams = new ArrayList<>();

            for (int i = 0; i < word.length(); ++i) {


                before = word.substring(0, i);
                focus = word.substring(i, i + 1);
                after = word.substring(i + 1, word.length());

                shortWord = before + after;

                /* Some printed statements to help with understanding how the loops work
                System.out.println("word: " + word);
                System.out.println("word len: " + word.length());
                System.out.println("i: " + i);
                System.out.println("before: " + before);
                System.out.println("focus: " + focus);
                System.out.println("after: " + after);
                System.out.println("short word: " + shortWord);
                System.out.println("");
                */

                subGeneratedAnagrams = webRecursiveAnagrams(shortWord);

                for (int j = 0; j < subGeneratedAnagrams.size(); ++j) {
                    newEntry = focus + subGeneratedAnagrams.get(j);
                    generatedAnagrams.add(newEntry);
                }
            }
            return generatedAnagrams;
        }
    }

    // does not work
    static void recursiveAnagram(String word) {

        String result = "";

        for (int i = 0; result.length() < word.length(); ++i) {

            for (int counter = 0, j = i; result.length() < word.length(); ++counter, ++j) {
                if (j == word.length() - 1) {
                    j = 0;
                }
                result += word.charAt(j);
            }
            System.out.println(result);
        }
    }
}