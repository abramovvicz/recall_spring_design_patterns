package varvCollection;

import io.vavr.collection.CharSeq;

public class SeqVarCollectionTests {
    public static void main(String[] args) {
        CharSeq.of("Vavr").filter(c->c != 'a').mkString(",");
    }
}
