package concurrency.SzymiLessons;

import java.io.IOException;
import java.util.function.BiFunction;


class VowelDemo implements Runnable {

    private String str = "GeeksForGeeks";

    @Override
    public void run() {
        str = str.toLowerCase();

        // toCharArray() is used to convert
        // string to char array
        char[] chars = str.toCharArray();

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            // check if char[i] is vowel
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
                    || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u') {
                // count increments if there is vowel in
                // char[i]
                count++;
            }
        }
        // display total count of vowels in string
        System.out.println("Total no of vowels in string are: " + count);
    }


    //przeczytaj pierwszy element z listy
    //policz sumę samogłosek
    //sprawdź kolejny element listy
    //policzy sumę samogłosek
    //...
    ///z sumuj liczbę wszystkich samogłosek

}

public class Vowel {
    public static void main(String[] args)
            throws IOException {

        BiFunction<Integer, Integer, String> biFunction = (x, y) -> x + y + "";

    }
}