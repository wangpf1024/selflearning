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
    public static final int capacity = 10;

    /**
     * 设置一个互斥信号量  mutex ，用户实现对公共缓冲区的互斥访问，初始值为 1.
     */
    private  static AtomicInteger mutex = new AtomicInteger(1);

    /**
     * 设置一个具有n个缓冲区的缓冲池
     * empty 表示缓冲区中空缓冲区数，初值为n。
     */
    public static String[] empty = new String[capacity];



    public static void waitProducer(String msg){
        while (mutex.get() <= 0){
            System.out.println(msg + ",等待设置一个互斥信号量mutex = 1");
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }
        mutex.set(0);
        System.out.println(msg + "设置一个互斥信号量mutex = 1");
    }


    public static void signalProducer(String msg){
        mutex.set(1);
        System.out.println(msg +"，设置一个互斥信号量mutex = 0");
    }


}
