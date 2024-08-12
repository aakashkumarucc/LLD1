package Streams;

import ComparableAndComparator.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(
                15,6,8,45,7,43,6,88,0
        ));
        //Write a method to extract only the odd number from the list
        Stream<Integer> s = list.stream();
        List<Integer> odds =    s.filter(integer -> integer%2 == 1).toList();
        System.out.println(odds);
        //How the above stream is working ?
        //1. List converted to Stream.
        //2. Stream will loop over the elements in the list.
        //3. Every element will be passed in the method.
        //4. lambda function will be applied over each element.
        //5. If lambda expression returns true, that element will be added to the final stream, else it will be rejected.
        //6. Finally we'll convert the stream back to the list.

        List<Student> students = Arrays.asList(new Student("Sasi", 4, 85),
                new Student("Rishi", 1, 80),
                new Student("Deepak", 3, 76),
                new Student("Krithi", 2, 92));

        System.out.println(students.stream().filter((student) -> student.getPsp() > 80).toList());

        //Iterate over the list and get the marks of each student.
        System.out.println(students.stream().map(student -> student.getName()).toList());

        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");

        // What does the following code snippet do?
        //concatenates all fruits into a single string
        String result = fruits.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Result: " + result);


        List<String> words = Arrays.asList("scaler", "bangalore", "india", "class", "oops", "streams", "java");
        //Count the number of words with length > 5.
        System.out.println(words.stream().filter(word -> word.length() > 4).count());

        //Convert the list of words to UPPER CASE.
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).toList();
        System.out.println(upperCaseWords);

        //Parallel streams
         Stream<Integer> s2 = list.parallelStream(); // 1,2,3,4,5,6
         s2.map((elem) -> { System.out.println("Multiplying by 3" + elem + " " + Thread.currentThread().getName());
             return 3*elem; }).filter((elem) -> { System.out.println("Filter " + elem + " " + Thread.currentThread().getName());
                 return elem<10; }).forEach(System.out::println);




    }
}
