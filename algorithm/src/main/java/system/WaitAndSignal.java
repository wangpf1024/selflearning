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

}
