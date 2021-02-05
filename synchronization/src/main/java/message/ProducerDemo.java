package message;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * 	申请空缓冲区
 * 	申请公共缓冲区池的互斥访问权限
 * 	将消息放入 in 指针指向的缓冲区
 * 	in 指针指向下一个空缓冲区
 * 	释放对公共缓冲区的互斥访问权
 * 	释放消息资源
 *
 */
public class ProducerDemo {



    /**
     * 	full 表示装有消息的缓冲区数，初始值为0.（一个缓冲区放一个消息）
     */
    public static AtomicInteger full  = new AtomicInteger(0);

    /**
     * 缓冲区地址
     */
    private static AtomicInteger in  = new AtomicInteger(0);

    /**
     * 生产消息：
     * @param msg
     */
    public static void produce(String msg){

        //申请空缓冲区
        waitProducer(msg);

        //申请公共缓冲区池的互斥访问权限
        MsgQueue.waitMsgQueue(msg);

        //将消息放入 in 指针指向的缓冲区
        MsgQueue.empty[in.get()] = msg;

        System.out.println("产生消息下标="+in.get()+",内容："+msg);

        //in 指针指向下一个空缓冲区
        in.addAndGet(1);

        //释放对公共缓冲区的互斥访问权
        MsgQueue.signalMsgQueue(msg);

        //释放消息资源
        signalProducer(msg);

    }

    /**
     * 申请空缓冲区
     */
    public static void waitProducer(String msg){
        while (full.get() >= MsgQueue.capacity){
            System.out.println(msg + ",申请空缓冲区失败，缓冲区已满 full = "+full.get());
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        full.addAndGet(1);
        System.out.println(msg + ",申请空缓冲区 full = "+full.get());
    }


    /**
     * 释放消息资源
     */
    public static void signalProducer(String msg){
        full.addAndGet(-1);
        System.out.println(msg+",释放消息资源 full = "+full.get());
    }


}
