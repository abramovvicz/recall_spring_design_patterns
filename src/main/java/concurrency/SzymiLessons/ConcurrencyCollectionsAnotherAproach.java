package concurrency.SzymiLessons;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class SomeCollectionsOfStringAnotherAproach implements Callable<Integer> {

    private CountDownLatch countDownLatch;
    private String str;
    private int numberOfVowel = 0;


    public SomeCollectionsOfStringAnotherAproach(String word) {
        this.str = word;
    }

    //    public SomeCollectionsOfString(String word, CountDownLatch countDownLatch) {
//        this.str = word;
//        this.countDownLatch = countDownLatch;
//    }
    private int sumVowelInWord() {
        for (int j = 0; j < str.length(); j++) {
            String strLoweCase = str.toLowerCase();
            if (strLoweCase.charAt(j) == 'a' || strLoweCase.charAt(j) == 'e'
                    || strLoweCase.charAt(j) == 'i'
                    || strLoweCase.charAt(j) == 'o'
                    || strLoweCase.charAt(j) == 'u' || strLoweCase.charAt(j) == 'y') {
                numberOfVowel++;
            }
        }
        System.out.println("Suma samogłosek w słowe: " + numberOfVowel);
        return numberOfVowel;
    }

    public int getNumberOfVowels() {
        return numberOfVowel;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        System.out.println("WORD: " + str);
        return sumVowelInWord();
    }
}

public class ConcurrencyCollectionsAnotherAproach {

    /*
    kolekcja stringów
    np. 3 stringi 3 taski
    taski - mają zliczyć samogłoski w tych stringach
    jak zliczą to na samym końcu ile jest w sumie samogłosek
    */

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> listOfStrings = List.of("Luke Skywalker", "Jean Luc Picard", "Darth Vader", "Obi One Kenobi");
        int sum = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<SomeCollectionsOfStringAnotherAproach> someCollectionsOfStringAnotherAproaches = new ArrayList<>();

        // //FutureTask  //done() -
        //        //CountDownLatch
        //        //collector zbiera dane

        for (int i = 0; i < listOfStrings.size(); i++) {
            SomeCollectionsOfStringAnotherAproach someCollectionsOfStringAnotherAproach = new SomeCollectionsOfStringAnotherAproach(listOfStrings.get(i));
            someCollectionsOfStringAnotherAproaches.add(someCollectionsOfStringAnotherAproach);
        }

        List<Future<Integer>> futureResults = executorService.invokeAll(someCollectionsOfStringAnotherAproaches);

        for (Future<Integer> integerFuture : futureResults) {
            sum = sum + integerFuture.get();
            System.out.println(sum);
        }

        System.out.println("Suma wszystkich samogłosek w liście to:  " + sum);

        executorService.shutdown();
    }


}
