package geek.homework;

public class Singleton {


    private static Singleton ourInstance = null;

    public static Singleton getInstance() {

        synchronized (ourInstance){

            if(ourInstance == null){

                ourInstance = new Singleton();

            }

        }

        return ourInstance;
    }


    private Singleton() {

    }




}
