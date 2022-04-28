package sandbox;

import io.vavr.control.Either;
import io.vavr.control.Option;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(MockitoJUnitRunner.class)
class CheckArgThatTest {

    @Mock
    CheckArgThat checkArgThat;

    @Mock
    ObjectToTest objectToTest;

    @Test
    void shouldTestFunctionality() throws Exception {
        //given
        objectToTest = new ObjectToTest("name", "dataChange");
        Either<Exception, String> map = CheckArgThat.from(objectToTest).flatMap(this::changeToCheckArgThat);





        CheckIfDataHasChanged checkIfDataHasChanged = new CheckIfDataHasChanged();

        CheckIfDataHasChanged spy = Mockito.spy(CheckIfDataHasChanged.class);

        //when
        ObjectToTest result = checkArgThat.createObjectTest(objectToTest.getName(), objectToTest.getData());
        Mockito.doReturn(true).when(spy).checkData(result.getData());

        //then//        verify(spy).checkData(any());
        System.out.println(result.getData());
        assertTrue(checkIfDataHasChanged.checkData(result.getData()));
    }

    Either<Exception, String> changeToCheckArgThat(CheckArgThat checkArgThat) {
        if (checkArgThat.getObjectToTest().getData().isEmpty()) {
            return Either.left(new UnsupportedOperationException("dupa"));
        } else {
            return Either.right(checkArgThat.getObjectToTest().getData());
        }
    }


    @Test
    void changeNameToUpperCase() {

        //given
        Either<String, Object> something_left = Either.left("something left");
        Either<String, Object> something_second_left = Either.left("something second left");
        Either<String, Object> something_third_left = Either.left("something third left");
        Either<Object, String> something_one_right = Either.right("something one right");
        Either<Object, String> something_second_right = Either.right("something second right");
        Either<Object, String> something_third_right = Either.right("something third right");

//        something_left.filterOrElse(x -> x.equals("something left"), o -> o + "dupa").dupa


        int input = 54;

        Option<String> output = Match(input).of(
                Case($(1), () -> someMethodThatReturnOptionString("dupa")),
                Case($(2), () -> someMethodThatReturnOptionString("two")),
                Case($(54), () -> someMethodThatReturnOptionString("dupa")));

        assertEquals(Option.of("dupa"), output);


    }

    Option<String> someMethodThatReturnOptionString(String message) {
        return Option.of(message);
    }


    void doSth() {
        System.out.println("dupa");
    }
}