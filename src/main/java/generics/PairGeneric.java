package generics;

public class PairGeneric <A,B>{
    private A first;
    private B second;
    public PairGeneric(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public static <K,V> void   doSomething(K a, V b) {
        System.out.println(a);
        System.out.println(b);
        System.out.println("So do something");

    }
    public void doSomethingElse(A a,B b) { // here <A,B> is not needed before return type
        System.out.println(a);
        System.out.println(b);
        System.out.println("So do something else");
    }

    public A getFirst() {
        return first;
    }
    public void setFirst(A first) {
        this.first = first;
    }
    public B getSecond() {
        return second;
    }
    public void setSecond(B second) {
        this.second = second;
    }

}
