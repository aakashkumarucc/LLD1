package ComparableAndComparator;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>(Arrays.asList(
                new Student("Dheerja",25,80),
                new Student("Sachin",24,70),
                new Student("Kholi",26,60)
        ));

        //Collections.sort(students); this gives error if student is not comparable i.e. student class has not implemented Comparable interface
        Collections.sort(students);

        System.out.println(students);

        Collections.sort(students,new StudentSorter());
        System.out.println(students);

        students.sort(new StudentSorter());
    }
}
