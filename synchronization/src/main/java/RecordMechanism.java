
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 记录型信号量
 * @author Arvin https://www.infoq.cn/u/shenghuoheike
 * @data 2021-01-30
 */
public class RecordMechanism {

    //初始化资源数量
    static int source = 2;

    //阻塞队列
    static Queue<String> process = new ArrayBlockingQueue<>(5);

    //用户申请资源

    /**
     * 1）当 source >= 0 表示资源数量。当 source <0 的时候 source的绝对值等于资源等待队列中阻塞进程的数量。
     * 2）每次 waitMethod 操作意味着请求一个资源，表示为 source = source - 1; 当 source < 0 表示资源分配完毕。
     *    因而进入 process 阻塞队列中 通过 block 进行自我阻塞。
     * @param pid
     */
    synchronized static void waitMethod(String pid){

        System.out.println(pid + "申请资源前，阻塞队列长度：" + process.size()+"，资源数量："+source);

        //使用资源
        source = source - 1;

        //阻塞队列数据新增
        if(source < 0){
            block(pid);
        }
    }

    //用于释放资源
    /**
     * 3）每次的 signalMethod 操作就意味着释放一个资源，故 source = source + 1; 并通过 wakeup 唤醒
     * 4）如果 source 的初始化值为1，表示只允许一个进程访问临界资源。此时型号量转化为互斥型号量。
     * 5）记录信号量机制的优点是不存在 "忙等"，采用"让权等待"的策略。
     * @param pid
     */
    static void signalMethod(String pid){

        System.out.println(pid +"释放资源");

        //判断释放需要释放资源
        boolean release = Math.abs(source) == process.size();
        //新增资源
        source = source + 1;

        if(release){
            wakeup(pid);
        }

    }

    static void block(String pid){

        process.add(pid);

        System.out.println(pid + "调用是无资源,添加阻塞队队列中：" + process.size()+"，资源数量："+source);

        //判断是否存在阻塞
        while (!process.isEmpty()){

            System.out.println(pid +",调用时候，模拟阻塞等待 ......");

            try {
                //获得资源 do something here
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
    }

    static void wakeup(String pid){

        String v = process.poll();

        System.out.println(pid + ",阻塞队列释放元素："+ v);
    }

    //执行测试
    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        10,
                        10,
                        10,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(10)) ;
        //线程P1
        Runnable P1 =  new Runnable() {
            public void run() {

                //申请资源
                RecordMechanism.waitMethod("P1");

                try {

                    System.out.println("P1，拿到资源了");

                    //获得资源 do something here
                    Thread.sleep(100);

                }catch (Exception e){

                }
                //释放资源
                RecordMechanism.signalMethod("P1");
            }
        };

        //线程P2
        Runnable P2 =  new Runnable() {
            public void run() {
                //申请资源
                RecordMechanism.waitMethod("P2");

                try {

                    System.out.println("P2，拿到资源了");

                    //获得资源 do something here
                    Thread.sleep(100);

                }catch (Exception e){

                }

                //释放资源
                RecordMechanism.signalMethod("P2");
            }
        };


        //线程P3
        Runnable P3 =  new Runnable() {
            public void run() {
                //申请资源
                RecordMechanism.waitMethod("P3");

                try {

                    System.out.println("P3，拿到资源了");

                    //获得资源 do something here
                    Thread.sleep(100);

                }catch (Exception e){

                }

                //释放资源
                RecordMechanism.signalMethod("P3");
            }
        };

        executor.execute(P1);

        executor.execute(P2);

        executor.execute(P3);

        try {


            Thread.sleep(3000);

        }catch (Exception e){

        }

        executor.shutdown();

    }
}
