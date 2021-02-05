package message;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 申请消息
 * 申请公共资源的互斥访问权限
 * 从 out 指针指向的缓冲区中区消息
 * out 指针指向下一个装有消息的缓冲区
 * 释放对公共缓冲池额互斥访问权
 * 释放缓冲区
 */
public class ConsumerDemo {

    /**
     * 	full 表示装有消息的缓冲区数，初始值为0.（一个缓冲区放一个消息）
     */
    public static AtomicInteger full  = new AtomicInteger(0);

    /**
     * 缓冲区地址
     */
    private static AtomicInteger out  = new AtomicInteger(0);

    /**
     * 消费消息：
     */
    public static void consumer(String msg){

        //申请空缓冲区
        waitConsumer();

        //申请公共缓冲区池的互斥访问权限
        MsgQueue.waitMsgQueue(msg);

        //从 out 指针指向的缓冲区中区消息 (10 % 10) - 1
        int left = ProducerDemo.full.get() % MsgQueue.capacity;

        int absLeft = Math.abs(left);

        System.out.println("消息缓冲区剩余大小："+absLeft);

        String content = MsgQueue.empty[out.get()];

        System.out.println("消费消息内容："+content);

        //out 指针指向下一个装有消息的缓冲区
        int outIdx = out.addAndGet(1) % MsgQueue.capacity;

        out.set(outIdx);

        //释放对公共缓冲区的互斥访问权
        MsgQueue.signalMsgQueue(msg);

        //释放消息资源
        signalConsumer();

    }

    /**
     * 申请空缓冲区
     */
    public static void waitConsumer(){
        while (full.get() >= MsgQueue.capacity){
            System.out.printf(".");
        }
        full.addAndGet(1);
    }


    /**
     * 释放消息资源
     */
    public static void signalConsumer(){
        //to do nothing
    }

}
