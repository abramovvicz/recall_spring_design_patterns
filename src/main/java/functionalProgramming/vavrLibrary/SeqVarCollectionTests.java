package vavrLibrary;

import io.vavr.collection.CharSeq;
import io.vavr.collection.Stream;

public class SeqVarCollectionTests {
    public static void main(String[] args) {

        //CharSeq - wrapper na String. Daje on możliwość wykonania operacji typowych dla kolekcji na ciągu znaków.
        String charSeq = CharSeq.of("Vavr").filter(c -> c != 'a').mkString(", ");
        System.out.println("CharSeq" + charSeq);


        final Stream<Integer> stream = Stream.from(1).filter(i -> i % 3 == 0);
        //tworzy od 1 do nieskończoności liczby, podzielne przez 3 bez reszy czyli 3,6,9 itd...
        //out 9
        System.out.println(stream.get(2));

        for (int i = 0; i < 10; i++) {
            System.out.println("i " + i + "  "   + i % 3);

        }
        GenerateStream generateStream = new GenerateStream();
//        generateStream.generate();
    }


}


class GenerateStream {

    public void generate() {
        //stream można generować za pomocą tabulate i fill
        Stream<Integer> tabulate = Stream.tabulate(10, this::getN);
        Stream<Double> fill = Stream.fill(2, () -> Math.random() + 1);
        System.out.println("tabulate " + tabulate.get());
        fill.toJavaList().forEach(System.out::println);
        tabulate.toJavaList().forEach(System.out::println);
    }

    private int getN(int i) {
        return i * 2 + 1;
    }
}