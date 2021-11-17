package varvCollection;

import io.vavr.collection.List;
import io.vavr.collection.Map;

public class VavrCollectionsBasicsTests {
    public static void main(String[] args) {

        //list filter
        List<Integer> filteredList = List.of(1, 2, 3, 4).filter(i -> i > 3);
        System.out.println("List filter: " + filteredList);

        //reduce vs fold
        final List<String> list = List.of("a", "aa", "b", "bb");
        Integer foldedLeftList = list.foldLeft(0, (i, s) -> i + s.length());
        System.out.println("Folded list: " + foldedLeftList);

        String reducedLeftList = list.reduceLeft((k, s) -> k + s);
        String reducedRightList = list.reduceRight((k, s) -> k + s);
        String reducedList = list.reduce((v, c) -> v + c);
        System.out.println("Reduced left list: " + reducedLeftList);
        System.out.println("Reduced right list: " + reducedRightList);
        System.out.println("Reduced list: " + reducedList);

        //group by
        List<String> groupedList = List.of("V", "av", "r", "rt", "");
        Map<Integer, List<String>> tuple2s = groupedList.groupBy(String::length);
        System.out.println("groupedList :" + tuple2s);


    }
}
