package sort;

public class SelectSorting {

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


    public static void selectSort(int[] R,int n){

        int min,i,j;

        for ( i = 0; i <=n-1; i++) {

            min = i;

            for (j = i + 1;  j <= n ;j++) {
                if(R[j] < R[min]) min = j;
            }

            if(min != i){
                int tmp = R[i];
                R[i] = R[min];
                R[min] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        SelectSorting.sysOutSortR();
        System.out.println();
        SelectSorting.selectSort(unSortR,8);
        SelectSorting.sysOutSortR();
    }

}
