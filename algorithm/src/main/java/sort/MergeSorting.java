package sort;

public class MergeSorting {

    /**
     * 待排序数组 R[0] 作为岗哨
     */
    static int[] unSortR = {72,26,57,88,42,80,73,48,60};


    /**
     * 输出排序数组元素
     */
    public static void sysOutSortR(){
        for (int i = 0; i < unSortR.length; i++) {
            System.out.print(unSortR[i]);
            System.out.print(",");
        }
    }


    /**
     * 有序序列的合并算法
     * 假设有两个有序序列 ah,......,am  和 am+1,......,an 它们相应的键值满足条件：
     *        Kh <= ...... <= Km
     *        Km+1 <= ...... <= Kn
     * 合并成一个有序序列 Rh,......Rn 使合并后的序列键值满足
     *        K'h <=..... <= K'm <= K'm+1 <= ......K'n
     *        O(n-h+1)
     * @param a
     * @param R
     * @param h
     * @param m
     * @param n
     */
    public static void merge(int[] a,int[] R,int h,int m, int n){

        // a 起始位置
        int k = h;
        int j = m +1;

        //将 a[] 中的记录从小到大合并到 R[]
        while ((h <= m) && (j <= n)){

            if(a[h] <= a[j]){ // a[h] 键值小，送入 R[K] 并修改 h 的值

                R[k] = a[h];

                h ++;

            }else { // a[j] 键值小，送入 R[k] 并修改 k 的值

                R[k] = a [j];

                j ++;
            }

            k ++;
        }

        /**
         *  j > n ,将 ah,......am 剩余部分插入 R的末尾
         *
         */
        while (h<=m){
            R[k] = a[h];
            h ++;
            k ++;
        }

        /**
         *  h > m, 将 am + 1,......,an 剩余部分插入 R的末尾
         */
        while (j<=n){
            R[k] = a[j];
            j ++;
            k ++;
        }


    }


    /**
     * 第一次合并算法
     *  在含有 n 个记录中的序列 a 中，将长度各为 h 的相邻的两个有序序列合并成一个长度为 2h 的一个有序序列并把结果存入 b 中。
     * @param a
     * @param b
     * @param n
     * @param h
     */
    public static void mergePass(int[] a,int[] b,int n,int h){

        int i = 0;

        while (i <= n-2*h +1) {

            /**
             * 将序列 ai,.....ai+h-1 和 序列 ai+h,......ai+2h-1
             * 合并到 bi,......bi+2*h-1
             */
            merge(a,b,i,i+h-1,i+2*h-1);

            //下标移动到 2*h
            i += 2*h;

        }

        // h < 剩余序列长度 < 2h
        if(i + h -1 <n){

            /**
             * 将序列 ai,......ai+h+1 和 序列 ai+h,......an
             * 和并到 bi,......bn
             */
            merge(a,b,i,i+h-1,n);

        }else{

            /**
             * 剩余序列长度 < h ,将 ai,.....an
             * 复制到 bi,......bn
             */
            for (int j = i; j < n; j++) {
                b[j]= a[j];
            }

        }

    }


    /**
     * 将序列 a1,a2,......,an 按关键字的非递增进行排序，
     * @param a
     * @param n
     */
    public static void mergeSort(int[] a,int n){

        // m 为子序列长度，初始化值为 1
        int m = 0;

        int[] b = new int[1];

        while (m < n){
            //将许阿里 a 中的有序子序列合并到 b
            mergePass(a,b,n,m);
            //子序列扩大 1 倍
            m = 2 * m;

            //将子序列 b 中的有序子序列合并到 a
            mergePass(b,a,n,m);
            //子序列扩大 1 倍
            m = 2 * m;
        }

    }

    public static void main(String[] args) {
        MergeSorting.sysOutSortR();
        System.out.println();
        MergeSorting.mergeSort(unSortR,8);
        MergeSorting.sysOutSortR();
    }

}
