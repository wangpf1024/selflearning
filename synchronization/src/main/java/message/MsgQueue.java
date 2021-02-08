package message;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 生产者进程可以用将它说生产的消息放入缓冲池的一个缓冲区，
 * 消费者进程可以用从缓冲区中取得一个消息消费。
 * 任意两个进程必须以互斥的方式访问公共缓冲池。
 * 当缓冲池空，没有任何消费者的消息时，消费者必须阻塞等待。
 * 当缓冲池装满消息，没有空闲缓冲区，生产者必须阻塞等待。
 */
public class MsgQueue {


    //缓冲区大小
    public static final int capacity = 4;

    /**
     * 设置一个互斥信号量  mutex ，用户实现对公共缓冲区的互斥访问，初始值为 1.
     */
    private  static AtomicInteger mutex = new AtomicInteger(1);

    /**
     * 缓冲内容区域
     */
    public static String[] emptyContent = new String[capacity];
    /**
     *  设置一个具有n个缓冲区的缓冲池
     *  empty 表示缓冲区中空缓冲区数，初值为n。
     */
    public static volatile AtomicInteger empty = new AtomicInteger(capacity);

    /**
     * 	full 表示装有消息的缓冲区数，初始值为0.（一个缓冲区放一个消息）
     * 	声明 Using volatile variables reduces the risk of memory consistency errors
     * 	https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html
     */
    public static volatile AtomicInteger full  = new AtomicInteger(0);


    public synchronized static void waitMsgQueue(String msg){
        while (mutex.get() <= 0){
            //System.out.println(msg + ",等待消息缓冲区释放");
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        mutex.set(0);
        //System.out.println(msg + ",锁定消息缓冲区");
    }


    public static void signalMsgQueue(String msg){
        mutex.set(1);
        //System.out.println(msg +",释放消息缓冲区");
    }


    /**
     * 将消息放入 in 指针指向的缓冲区
     * @param in
     * @param msg
     */
    public static int addContent(int in,String msg){

        while (empty.get() <= 0){
            System.out.println("队列已满！");
        }

        //将消息放入 in 指针指向的缓冲区
        MsgQueue.emptyContent[in] = msg;

        //System.out.println(msg+",消息队列下标位置="+in+",内容："+msg);

        System.out.println("生产者-"+MsgQueue.msg());

        return empty.addAndGet(-1);

    }

    /**
     * 从 out 指针指向的缓冲区中区消息
     * @param out
     */
    public static String getContent(int out){

        //将消息放入 in 指针指向的缓冲区
        String content = MsgQueue.emptyContent[out];

        MsgQueue.emptyContent[out] = null;

        System.out.println("消费者-"+MsgQueue.msg());


        return content;

    }


    /**
     * 输出消息内容
     */
    public static String msg(){
        StringBuffer msg = new StringBuffer("当前队列数据：");
        for (int i = 0; i < emptyContent.length; i++) {
            msg.append("[").append(emptyContent[i]).append("]");
        }
        return msg.toString();
    }


    /**
     * 申请空缓冲区
     */
    public synchronized static void waitProducer(String msg){
        while (MsgQueue.full.get() >= MsgQueue.capacity){
            System.out.println(msg + ",申请空缓冲区失败，缓冲区已满");
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        MsgQueue.full.addAndGet(1);
       // System.out.println(msg + ",申请空缓冲区成功");
    }


    /**
     * 释放消息资源
     */
    public synchronized static void signalProducer(String msg){
        MsgQueue.full.addAndGet(-1);
        //System.out.println(msg+",释放消息资源 full = "+MsgQueue.full.get());
    }



}
