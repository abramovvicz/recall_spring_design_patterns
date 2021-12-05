package functionalProgramming.functionalProgrammingDemos.chapterOne;

public class FunctionAsData {

    public static void main(String[] args) {

        final Boolean IS_DEVELOPMENT = true;

        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());

    }

    protected static class Person {
        String name;
        Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
        }
    }

    protected static class DataLoader {

        public final NoArgFunction<Person> loadPerson;

        public DataLoader(Boolean isDevelopment) {
            this.loadPerson = isDevelopment ? this::loadFakePerson : this::loadRealPerson;
        }

        private Person loadRealPerson() {
            System.out.println("Loading person...");
            return new Person("Real Person", 23);
        }

        private Person loadFakePerson() {
            System.out.println("Loading in progress...");
            return new Person("Fake person", 34);
        }
    }
}
