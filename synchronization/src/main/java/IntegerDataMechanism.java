import java.applet.Applet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 整型信号量
 * @author Arvin https://www.infoq.cn/u/shenghuoheike
 * @data 2021-01-30
 */
public class IntegerDataMechanism{

     //（整型信号量的wait和signal 操作）

     //定义一个整型变量，用变量来标记资源的使用情况。如果整型量 > 0 , 说明有可用资源
     static int mutex = 1;

     //公共资源计数器
     static int counter = 0;

     //用户申请资源

    /**
     * 使用 synchronized 关键字模拟 不可中断效果。
     * synchronized 用于 static 时候，相当于将锁加到了当前 Class 对象上，因此所有对该方法的调用
     * 必须获取 Class 对象的锁。
     *
     * 普通方法声明 synchronized 被调用时，掉用的线程首先必须获得当前对象的锁，
     * 若对象锁被其他线程持有，则调用线程会等待，方法结束后，对象锁会被释放。
     * @param pid
     * @return
     */
    synchronized static int waitMethod(String pid){

         //如果整型量 <= 0 ,说明资源忙，进程必须等待，
         while (mutex <= 0){
             //打印机等待
             System.out.println(pid +"在等待 ......");
         }

         System.out.println(pid +"获取资源 " + mutex);

         mutex = mutex - 1;

         return mutex;
     }

    //用于释放资源
    static void signalMethod(String pid){
        System.out.println(pid  +"释放资源");
        mutex = mutex + 1;
    }


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
                //申请资源
                int p1v = IntegerDataMechanism.waitMethod("P1");

                System.out.println("P1 获取资源 = "+p1v);

                IntegerDataMechanism.counter ++;

                //释放资源
                IntegerDataMechanism.signalMethod("P1");

                System.out.println("资源计数器----->"+IntegerDataMechanism.counter);
            }
        };

         //线程P2
        Runnable P2 =  new Runnable() {
            public void run() {
                //申请资源
                int p2v = IntegerDataMechanism.waitMethod("P2");

                System.out.println("P2 获取资源 = "+p2v);

                IntegerDataMechanism.counter ++;

                //释放资源
                IntegerDataMechanism.signalMethod("P2");

                System.out.println("资源计数器----->"+IntegerDataMechanism.counter);
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
