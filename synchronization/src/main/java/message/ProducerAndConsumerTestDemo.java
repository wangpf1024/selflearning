package message;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 测试用例
 */
public class ProducerAndConsumerTestDemo {


    public static void main(String[] args) {


        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        10,
                        10,
                        10,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(100)) ;



        for (int i = 0; i < 2; i++) {
            System.out.println("生产者提交生产任务[" +i+"]次");
            final int id = i;
            Runnable p1 =  new Runnable() {
                public void run() {
                    //
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e){

                    }
                    ProducerDemo.produce("生产消息序列ID = "+ id);
                }
            };

            executor.execute(p1);
        }



        try {
            //获得资源 do something here
            Thread.sleep(10000);
        }catch (Exception e){

        }

        //executor.shutdown();

    }
}
