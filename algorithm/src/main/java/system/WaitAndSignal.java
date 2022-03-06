package system;

public class WaitAndSignal {


    /**
     *
     * 记录型信号量的数据类型
     *
     * Type semaphore = record
     *                  Value: integer; //资源数量
     *                  L: list of process; //阻塞队列
     *
     *
     * var S,N,mutex:semaphore;
     *
     * Ncount,Scount:integer;
     *
     * mutex.value = 1;
     * S.value = 1;
     * N.value = 1;
     * Ncount = 0;
     * Scount = 0;
     *
     * // 从北到南
     * NorthToSouth
     * Begin
     *      Repeat
     *          wait（S）;
     *          if(Scount ==0) wait(mutex);
     *          Scount ++;
     *          signal(S);
     *          //通过独木桥过河
     *          wait(S);
     *          Scount --;
     *          if(Scount ==0) signal(mutex);
     *          signal(S);
     *      Until false;
     * End
     *
     * // 从 南到北
     *
     * SouthToNorth:
     * Begin
     *     Repeat
     *         wait(N);
     *         if(Ncount == 0) wait(mutex);
     *         Ncount ++;
     *         Signal(N);
     *         //通过独木桥过河
     *         wait(N);
     *         Ncount --;
     *         if(Ncount == 0) signal(mutex);
     *         signal(N);
     *     Until false;
     * End
     *
     */


    /**
     * var e1,f1,e2,f2:semaphore;
     * e1.value = 1;
     * e2.value = 1;
     * f1.value = 0;
     * f2.value = 0;
     *
     * read
     *
     * Begin
     *     Repeat
     *          wait(e1);
     *          //读取一条记录放入缓冲区B1中
     *          signal(f1);
     *     Until false;
     * end
     *
     *
     * move
     *
     * Begin
     *     Repeat
     *          wait(f1);
     *          //从缓冲区B1中取出一条记录
     *          signal(e1);
     *          wait(e2);
     *          //整理记录并放入缓冲区B2中
     *          signal(f2);
     *     Until false;
     * end
     *
     * print
     *
     * Begin
     *     Repeat
     *          wait(f2);
     *          //从缓冲区B2中取出一条记录，并打印
     *          signal(e2);
     *     Until false;
     * end
     *
     */

}
