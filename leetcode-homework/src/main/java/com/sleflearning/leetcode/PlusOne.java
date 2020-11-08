package com.sleflearning.leetcode;


/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {


    /**
     * 实时证明这种方式不可以的
     * 数值类型 存在取值范围问题
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {

        String v= "";

        for (int i = 0; i < digits.length; i++) {
            v +=digits[i];
        }

        Long b = Long.valueOf(v) + 1;

        String v1 = String.valueOf(b);

        int[] r = new int[v1.length()];

        int sl = v1.length();


        for (int i = 0; i < sl; i++) {
            String a = String.valueOf(v1.charAt(i));
            r[i] = Integer.valueOf(a);
        }

        return r;
    }


    public static int[] plusOne2(int[] digits) {

        int size = digits.length;

        int[] r = new int[size];

        int i = 0;

        for (int j = size - 1; j >= 0; j--) {
            if(digits[j] == 9){
                r[j] = 1;
                i ++;
            }
        }
        if(size > i ){
            for (int j = size -1 ; j >= 0; j --) {
                if(r[j] == 1){
                    digits[j] = 0;
                }else{
                    digits[j] ++;
                    break;
                }
            }
        }else{

            r = new int[size + 1];
            r[0] = 1;
            return r;
        }

        return digits;
    }


    public static int[] plusOne4(int[] digits) {
        int size = digits.length;
        for (int j = size -1 ; j >= 0; j --) {
            if(digits[j] == 9){
                if(j == 0){
                    int[] r = new int[size + 1];
                    r[0] = 1;
                    return r;
                }
                digits[j] = 0;
            }else{
                digits[j] ++;
                break;
            }
        }
        return digits;
    }



    public static void main(String[] args) {

        int[] a = {9,8,7,9,9};

       // int[] a = {9,9,9};

        int[] b = PlusOne.plusOne4(a);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }
}
