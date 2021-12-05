package concurrency.pkLesson.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class VowelsCounter {

    public static void main(String[] args) {

        VowelsCounter.countVowels("string");

        Test test = new Test() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };

        Map<Integer, String> map = new HashMap<>();
        map.put(null, "string");
    }

    public static long countVowels(String word) {

        String changeString = "SomeString_2445";
        int i = changeString.lastIndexOf("_");
        System.out.println(i);
        String substring = changeString.substring(0, changeString.lastIndexOf("_"));
        System.out.println(substring);



        return Optional.ofNullable(word)
                .orElseThrow(IllegalAccessError::new)
                .toLowerCase()
                .chars()//we can user codePoints() retruns IntStream
                .filter(letter -> Set.of('a', 'i', 'o', 'u', 'y').contains(letter))
                .count();
    }

}
