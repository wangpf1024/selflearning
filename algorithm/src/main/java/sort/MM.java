package sort;

/**
 * n 阶矩阵的逆置运算
 */
public class MM {

    int n;

    void MM(int A[][]){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

}
