package sort;

public class HeapSorting {

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


    /**
     * 假设 R[k],R[k+1],.....R[m]是以 R[k] 为根的完全二叉树，R[k] 的左，右子树满足堆的性质。
     * 本算法调整 R[k] 是整个 R[k],R[k+1],.....R[m] 满足堆的性质。
     * @param R
     * @param k
     * @param m
     */
   public static int[] sift(int[] R,int k,int m){

       int i,j,x;
       int t;

       i =k;j=2*i;

       x = R[k];
       t = R[k];

       while (j <=m){

           // 若存在右子树，且右子树的根关键子小，则沿右分支筛选。
           if(j<m && R[j] > R[j+1])j++;

           //筛选完毕
           if(x < R[j])break;

           else{
               R[i] = R[j];
               i = j;
               j = 2 * i;
           }
       }
       //填入恰当的位置
       R[i] = t;
       return R;
   }

    /**
     * 根据完全二叉树的特性最后一个非终端结点是第 n/2 个元素，即对于 i > n/2 的结点 ki 都没有孩子结点，因此以这样
     * 的ki 为根的树已经是堆，所以筛选只需从 n/2 开始，逐步把 k(i/2),k(i/2-1),....k0 为根的子树 "筛选" 成堆。
     * @param R
     */
   public static void HeapSort(int[] R,int n){

       int i;

       //从第 n/2 个记录开始进行筛选，建堆
       for (i = n/2;  i >= 1 ; i--) {
           R = HeapSorting.sift(R,i,n);
       }

       for(i = n; i >=2; i--){
           //将堆定元素与堆中最后一个元素互换
           int tmp = R[1];
           R[1] = R[i];
           R[i] = tmp;
           //调整新堆
           R = HeapSorting.sift(R,0,i -1);
       }

       unSortR = R;
   }

    public static void main(String[] args) {
        HeapSorting.sysOutSortR();
        System.out.println();
        HeapSorting.HeapSort(unSortR,8);
        HeapSorting.sysOutSortR();
    }

}
