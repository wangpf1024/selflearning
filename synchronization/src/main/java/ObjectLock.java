import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ObjectLock {




    public synchronized static void sayHello(String a){
        System.out.println("hello" + a);
        try {
            //获得资源 do something here
            Thread.sleep(1000);
        }catch (Exception e){
        }
        System.out.println("good bey");
    }

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        10,
                        10,
                        10,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(100)) ;


        for (int i = 0; i < 4; i++) {
             final int v = i;
             Runnable P1 =  new Runnable() {
                public void run() {
                    ObjectLock objectLock = new ObjectLock();
                    objectLock.sayHello(v+"");
                }
            };
            executor.execute(P1);
        }



        try {
            //获得资源 do something here
            Thread.sleep(500);
        }catch (Exception e){

        }

        executor.shutdown();
    }
}
