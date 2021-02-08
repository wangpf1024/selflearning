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
     * 缓冲区地址
     */
    private static volatile AtomicInteger out  = new AtomicInteger(0);

    /**
     * 消费消息：
     */
    public static void consumer(String msg){

        //申请空缓冲区
        waitConsumer(msg);

        //申请公共缓冲区池的互斥访问权限
        MsgQueue.waitMsgQueue(msg);

        //从 out 指针指向的缓冲区中区消息
        String content = MsgQueue.getContent(out.get(),msg);

        System.out.println(msg+",获取队列中的内容"+content);

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
    public synchronized static void waitConsumer(String msg){
        while (MsgQueue.empty.get() == MsgQueue.capacity){
            System.out.println(msg + ",消息队列中无数据，等待中...");
        }
        System.out.println(msg + ",获取缓冲区数据");
    }


    /**
     * 释放消息资源
     */
    public static void signalConsumer(){
        //to do nothing
        MsgQueue.empty.addAndGet(1);
    }


}
