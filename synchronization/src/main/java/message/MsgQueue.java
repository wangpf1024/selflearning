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
    public static final AtomicInteger empty = new AtomicInteger(capacity);


    public static void waitMsgQueue(String msg){
        while (mutex.get() <= 0){
            System.out.println(msg + ",等待设置一个互斥信号量mutex = 1");
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        mutex.set(0);
        System.out.println(msg + "设置一个互斥信号量mutex = 0");
    }


    public static void signalMsgQueue(String msg){
        mutex.set(1);
        System.out.println(msg +"，设置一个互斥信号量mutex = 1");
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

        System.out.println(msg+",产生消息下标="+in+",内容："+msg);

        return empty.addAndGet(-1);

    }

    /**
     * 从 out 指针指向的缓冲区中区消息
     * @param out
     * @param msg
     */
    public static int getContent(int out,String msg){

        //将消息放入 in 指针指向的缓冲区
        String content = MsgQueue.emptyContent[out];

        System.out.println(msg+",消费消息内容："+content);

        return empty.addAndGet(1);
    }


    /**
     * 输出消息内容
     */
    public static void printMsg(){
        System.out.println();
        for (int i = 0; i < emptyContent.length; i++) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+i + "," +emptyContent[i]);
        }
    }


}
