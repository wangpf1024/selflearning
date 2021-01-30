import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Arvin https://www.infoq.cn/u/shenghuoheike
 * @data 2021-01-30
 */
public class IntegerDataDemo {

    //公共资源计数器
    static int counter = 0;

    //执行测试
    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        10,
                        10,
                        10,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(100)) ;
         //线程P1
        Runnable P1 =  new Runnable() {
            public void run() {
                int p1v = IntegerDataDemo.counter;
                System.out.println("P1拿到的值 = "+p1v);
                IntegerDataDemo.counter  ++;
                System.out.println("P1++后的值 = "+ IntegerDataDemo.counter);
            }
        };

         //线程P2
        Runnable P2 =  new Runnable() {
            public void run() {
                int p2v = IntegerDataDemo.counter;
                System.out.println("P2拿到的值 = "+p2v);
                IntegerDataDemo.counter  ++;
                System.out.println("P2++后的值 = "+ IntegerDataDemo.counter);
            }
        };


        executor.execute(P1);

        executor.execute(P2);


        try {
            //获得资源 do something here
            Thread.sleep(500);
        }catch (Exception e){

        }

        executor.shutdown();

    }

}
