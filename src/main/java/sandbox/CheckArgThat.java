package sandbox;

import io.vavr.control.Either;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class CheckArgThat {
   private ObjectToTest objectToTest;


    private CheckArgThat(ObjectToTest objectToTest) {
        this.objectToTest = objectToTest;
    }


    public static Either<Exception, CheckArgThat> from(ObjectToTest objectToTest) {
        if (objectToTest == null) {
            return Either.left(new UnsupportedOperationException("some exception"));
        } else {
            return Either.right(new CheckArgThat(objectToTest));
        }
    }



    ObjectToTest createObjectTest(String name, String data) {
        objectToTest = new ObjectToTest("name", data);
        changeNameToUpperCase(objectToTest.getData());
        System.out.println(objectToTest.getData());
        return objectToTest;
    }

    String changeNameToUpperCase(String data) {
        String changedData = data.toUpperCase();
        objectToTest.setData(changedData);
        log.info("name was changed: {}", changedData);
        return changedData;
    }
}
