package Lambda;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class LambdaMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);

        list.stream().forEach(o -> System.out.println(o));
        list.stream().forEach(System.out::println);
        list.stream().limit(5).forEach(System.out::println);
        list.stream().filter(o->o%2==0).forEach(System.out::println);
        list.stream().mapToInt(o -> o).sum();

        list.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });
    }

    static void testPerson() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("A", 10));
        list.add(new Person("B", 20));
        list.add(new Person("C", 30));

        list.stream().filter(Person::isAdult);
        int sumAge = list.stream().mapToInt(Person::getAge).sum();
        list.stream().filter(o->o.getName().contains("A"));
        List<Person> listA = list.stream().filter(o->o.getName().contains("A")).collect(Collectors.toList());
    }

    static class Person {
        private String name;
        private int age;

        public int getAge() {return age;}
        public String getName() {return name;}

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public boolean isAdult() {
            return age >= 19;
        }

        public String toString() {
            return String.format("%s: %d", name, age);
        }
    }
}
