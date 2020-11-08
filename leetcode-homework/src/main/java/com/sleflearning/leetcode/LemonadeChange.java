package com.sleflearning.leetcode;


/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class LemonadeChange {


    /**
     * 简单的说，问题能够分级成子问题来解决。子问题的最优解能够递归推到最终问题的最优解，这种子问题最优解称为最优子结构
     * 数值之间右连续  5 ，10 ，20
     * @param bills
     * @return
     */

    public boolean lemonadeChange(int[] bills) {



        if(bills == null || bills.length ==0){
            return false;
        }

        int size = bills.length;

        int fiveSize = 0;

        int tenSize = 0;

        int price = 5;

        for (int i = 0; i < size; i++) {

            int k = bills[i];

            switch (k) {
                case 5 :
                    fiveSize ++;
                    break;
                case 10 :
                    tenSize ++;
                    int a = fiveSize --;
                    if( a < 0){
                        return false;
                    }
                    break;
                case 20 :
                    int c = 15;
                    if(tenSize > 0){
                        tenSize --;
                        c = c - 10;
                    }
                    int v = c/price;
                    if(fiveSize - v < 0){
                        return false;
                    }
                    fiveSize = fiveSize - v;
                    break;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        LemonadeChange lemonadeChange = new LemonadeChange();

        int[] a = new  int[]{5,5,5,10,20};

        boolean f = lemonadeChange.lemonadeChange(a);

        System.out.println(f);
    }
}
