package MethodConsturctorReference;

public class Stuff {

    public Stuff(){
        System.out.println("Stuff Constructor");
    }

    public static void doStuff(){
        System.out.println("Doing task doStuff");
    }

    public void printNUbmer(){
        for(int i =1;i<=5;i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
