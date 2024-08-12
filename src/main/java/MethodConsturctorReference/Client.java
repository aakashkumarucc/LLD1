package MethodConsturctorReference;

import java.util.List;

public class Client {
    public static void main(String[] args) {

        //providing the implementation of WorkInter
        //using Lambdas
        WorkInter workInter = () -> {
            System.out.println("This is doTAsk new Methods");
        };
        workInter.work();

        //using a function implementation that was already defined
        //Lets doStuff of stuff class
        //Static Method Refer
        WorkInter workInter1 = Stuff::doStuff;//note we are not calling the doStuff, we are using its body(referring)

        //Instance Method Refer
        Stuff stuff = new Stuff();
        Runnable runnable1 = stuff::printNUbmer;

        /*
        Please note method jo refer kr rahe hai....this is similar to(not exactly) overriding interface methods--
         so arguments should be same; return type can be different
         */

        //Constructor Reference
        //lambda implementation me agar hm new object return kr rahe the(constructor call ho raha hoga)-
        // return new Studnet() ko replace kr sakte Student::new

        //using lambdas
        Provider provider = () -> {
          return  new Stuff();
        };
        //usinng reference
        Provider provider1 = Stuff::new;
        Stuff stuff1 = provider1.getStuff();

        //Another Example
        List<Integer> integers = List.of(13,434,23,434,6,32);
        //to list them out
        integers.stream().forEach(e -> System.out.println(e));
        //samething using reference operators
        integers.stream().forEach(System.out::println);

    }
}
