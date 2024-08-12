package lambdas;

import java.util.*;
import java.util.function.*;

public class Client {
    public static void main(String[] args) {
        //FunctionalInterface obj = new FunctionalInterface() //doesn't work that way

        //Way-1
        ImplementaionClass ojb = new ImplementaionClass();
        ojb.func();

        //Way-2
        //Anonymous Class- Anonymous classes are inner classes with no name. Since they have no name, we can’t use them in order to create instances of anonymous classes. As a result, we have to declare and instantiate anonymous classes in a single expression at the point of use.
        FunctionalInterface obj1 = new FunctionalInterface() {
            @Override
            public void func() {
                System.out.println("Anonymous class");
            }
        };

        BiConsumer<String,Integer> biConsumer = new BiConsumer<String,Integer>() {

            @Override
            public void accept(String s, Integer integer) {
                System.out.println("String " + s + ", Integer " + integer);
            }
        };

        biConsumer.accept("scine",56);

        //Lambda Expression
        //3rd way in which we can provide the method body for an interface

        Consumer<String> consumer = (s) -> System.out.println("Consumer lambda implementation " + s);//{} ko hata sake kyuki ek line hi tha our void return hai

        consumer.accept("Aakash");

        BiConsumer<Integer,String> biConsumer2 = (a,b) -> System.out.println("BiConsumer lambda implementation " + a + " and " + b);
        biConsumer2.accept(45,"Rohit");

        //fun(T t1, T t2) returns T

        //BinaryOperator<Integer> binaryOperator = (a,b) -> a+b;
//       above and same gave same result
        BinaryOperator<Integer> binaryOperator = (a,b) -> {
            return a+b;
        };

        System.out.println("sum of binaryOperation "+binaryOperator.apply(45,56));

        //Remember implementation function of Predicate return boolean
        Predicate<String> predicate = (s) -> s.length()>5;
        System.out.println(predicate.test("scine"));

        BiPredicate<String,Integer> biPredicate = (str,x) -> str.length()>x;

        System.out.println(biPredicate.test("scine",56));


        //Lets make the Comparator
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(2,"Mahses",45),
                new Student(4,"Bumaa",34),
                new Student(7,"Dhone",42)
        ));
        Comparator<Student> comparator = (a,b) -> {
          return a.getId()-b.getId();
        };
        Collections.sort(students,comparator);
        System.out.println(students);

        //Runnable

        Runnable runnable = () -> {
            System.out.println("Runnable lambda implementation by "+Thread.currentThread().getName());

        };
        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(
                () -> System.out.println("Hello World, printed by " + Thread.currentThread().getName())
        );
        thread1.start();

    }
}
