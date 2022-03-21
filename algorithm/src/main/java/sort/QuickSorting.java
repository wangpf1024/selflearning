package sort;

public class QuickSorting {


    /**
     * 待排序数组 R[0] 作为岗哨
     */
    static int[] unSortR = {0,45,38,66,90,88,10,25,45};


    /**
     * 输出排序数组元素
     */
    public static void sysOutSortR(){
        for (int i = 0; i < unSortR.length; i++) {
            System.out.print(unSortR[i]);
            System.out.print(",");
        }
    }


    static int quickPartition(int[] R, int i,int j){

        /**
         * 2.把 **R[i]** 送入工作单元 **X** 中保存
         */
        int  x = R[i];

        while(i < j){

            /**
             * 3.首先 **j** 从 **n** 逐渐减少找到第一个满足 **R[j] < x** 的记录，这时候将 **R[j]** 移至 **R[i]** 的位置；
             */
            while (i<j && R[j] <= x) j --;
            R[i] = R[j];

            /**
             * 4.然后另 **i** 自 **i + 1** 起逐渐增大找到第一个满足 **R[i] > x** 的记录，这时候将 **R[i]** 移至 **R[j]** 的位置；
             */
            while (i<j && R[i] >= x) i ++;
            R[j] = R[i];

        }
        R[i] = x;

        return i;
    };


    static void quickSorting(int[] R,int i,int j){

        /**
         * 1.附设两个指针 **i** 和 **j**，它们的初值分别是 **0** 和 **n**
         */
        if(i < j){

            int temp = quickPartition(R,i,j);

            /**
             * 5.接着 **j** 自 **j - 1 **起重复上述过程，直至 **i = j**，测试 **i** 便是 **x** 记录所应在的位置，至此一趟排序完成。
             */
            quickSorting(R,i,temp -1);

            quickSorting(R,temp + 1,j);
        }
    }

    public static void main(String[] args) {


        QuickSorting.sysOutSortR();
        QuickSorting.quickSorting(unSortR,0,unSortR.length-1);
        System.out.println();
        QuickSorting.sysOutSortR();
    }
}
