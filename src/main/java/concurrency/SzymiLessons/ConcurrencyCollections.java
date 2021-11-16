package concurrency.SzymiLessons;


import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class SomeCollectionsOfString implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private List<String> listOfStrings;
    private int numberOfVowel = 0;


    public SomeCollectionsOfString(List<String> listOfStrings, CyclicBarrier cyclicBarrier) {
        this.listOfStrings = listOfStrings;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("odczytuje stringa i sprawdza czy sa samogłoski");
            for (int i = 0; i < listOfStrings.size(); i++) {
                String str = listOfStrings.get(i);
                System.out.println(listOfStrings.size());
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e'
                        || str.charAt(i) == 'i'
                        || str.charAt(i) == 'o'
                        || str.charAt(i) == 'u') {
                    // count increments if there is vowel in
                    // char[i]
                    numberOfVowel++;
                }
            }
            cyclicBarrier.await();
            System.out.println("liczba samogłosek" + numberOfVowel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}


public class ConcurrencyCollections {

/*

kolekcja strintgów
np. 3 stringi 3 taski
taski - mają zliczyć samogłoski w tych stringach
jak zliczą to na samym końcu ile jest w sumie samogłosek


*/

    public static void main(String[] args) {

        List<String> listOfStrings = List.of("Luke Skywalker", "Jean Luc Picard", "Darth Vader", "Obi One Kenobi");
        CyclicBarrier cyclicBarrier = new CyclicBarrier(listOfStrings.size());
            new Thread(new SomeCollectionsOfString(listOfStrings, cyclicBarrier)).start();


//        listOfStrings.stream().map(x ->)

    }


}
