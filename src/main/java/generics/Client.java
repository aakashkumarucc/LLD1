package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        /*
        List<Pair> p = new ArrayList<Pair>(Arrays.asList(
                new Pair(1.2,1.3), new Pair("Dheeraj",1.3)
        ));
        //Using objects doesn't give compile time error but gives run time error
        for(Pair p1 : p){
            String f = (String) p1.getFirst();
            String s = (String) p1.getSecond();
            System.out.println(f);
            System.out.println(s);
            //will give runtime error
        }
         */

        //Using Generics
        PairGeneric<Integer,String> a = new PairGeneric<>(1,"Aakash");
        PairGeneric<String,Integer> b = new PairGeneric<>("Bakash",1);

        // RAW types, before Java 5
        // No compile time safety
        /*
         HashMap hm = new HashMap();
        hm.put(1,"Dheeraj");
        hm.put("Dheeraj",1);
        for(var v: hm.keySet()){
            int i = (Integer) v;
            System.out.println(i);
        }

        // After Java 5, compile time safety
        HashMap<String, Integer> hmap = new HashMap<>();
        hmap.put(1, "Dheeraj"); // will get compile time error here only saving us from run-time issues

        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Double> l3 = new ArrayList<>();
        //Adding a breakpoint here to see the data types at runtime(Type Erasure)
        System.out.println("Done");
         */


        // Understanding Generic Methods
        //Note : sir told you can return a generic type parameter as well, but it has to be a declared (in our method we can return say K but not any random Z say)
        //And we can't pass non-static members to our this method(here we can't pass A,B). But we can very well pass it to a non static generic method
        PairGeneric.doSomething("Dheeraj", 1);
        PairGeneric.doSomething(21,"Dheeraj");
        //Note : above were static methods

        //Below is a non-static generic method that need a class to be instantiated(since class was generic, we had to pass the data type while instantiating the class)
        //Therefor for non-static generic method, what type will be passed will be fixed and order
        a.doSomethingElse(56,"Dheerag");


    }
}
