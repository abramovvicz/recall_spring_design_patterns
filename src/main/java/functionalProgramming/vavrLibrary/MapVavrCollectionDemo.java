package functionalProgramming.vavrLibrary;

import io.vavr.collection.HashMap;

public class MapVavrCollectionDemo {
    public static void main(String[] args) {

        HashMap<Integer, String> vavrMap = HashMap.of(1, "V", 2, "a", 3, "v", 4, "r");
        System.out.println(vavrMap.get(3));
        System.out.println(vavrMap.get(5));

        System.out.println(vavrMap.filterKeys(l -> l == 2));
        System.out.println(vavrMap.filterValues(l -> l.equals("V")));

    }


}
