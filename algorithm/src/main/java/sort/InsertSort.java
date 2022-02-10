package sort;

import java.util.List;

/**
 * 插入排序
 * @author Arvin
 * @date 2022-11
 */
public class InsertSort {

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
     * 直接插入排序
     * @param R 顺序表 R
     * @param n 表长
     */
    public static void straightInsertSort(int[] R, int n){
        int i,j;
        for (i = 2; i < n; i++) {
             R[0] = R[i];//设置岗哨
             j = i - 1;
             while (R[0] < R[j]){//与岗哨进行比较，直到值不大于岗哨
                 R[j+1] = R[j];
                 j--;
             }
             R[j + 1] = R[0];
        }
    }


    public static void main(String[] args) {

        InsertSort.straightInsertSort(unSortR,unSortR.length);

        InsertSort.sysOutSortR();

    }

}
