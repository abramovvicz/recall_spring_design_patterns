package pkLesson.streams;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


class VowelsCounterTest {


    @Test
    void shouldCountVowels(){
        VowelsCounter vowelsCounter = new VowelsCounter();
        long result = vowelsCounter.countVowels("hello world");


        Assertions.assertEquals(3, result);

    }

    @Test
    void shouldCountVowels_checkNPE(){
        VowelsCounter vowelsCounter = new VowelsCounter();
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->vowelsCounter.countVowels(null));

    }

    @Test(expected = NullPointerException.class)
    void shouldCountVowels_checkNPEAnotherAproach(){
        VowelsCounter vowelsCounter = new VowelsCounter();
        org.assertj.core.api.Assertions.assertThatExceptionOfType(NullPointerException.class).isThrownBy(()->vowelsCounter.countVowels(null));

    }
}