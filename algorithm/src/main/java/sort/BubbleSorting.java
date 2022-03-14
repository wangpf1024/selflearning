package sort;

public class BubbleSorting {

    /**
     * 待排序数组
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


    public static void bubbleSort(int[] R, int n){
        int i,j,temp,endSort;
        for (i=1; i <=n-1; i++) {
            endSort = 0;
            for (j = 1; j <= n-i-1; j++) {
                if(R[j] > R[j+1]){
                    temp = R[j];

                    R[j] = R[j+1];
                    R[j + 1] = temp;

                    endSort = 1;
                }
            }
            if(endSort == 0)break;
        }
    }

    public static void main(String[] args) {
        BubbleSorting.bubbleSort(unSortR,unSortR.length);
        BubbleSorting.sysOutSortR();
    }
}
