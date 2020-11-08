package com.sleflearning.leetcode;


/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStockII {


    /**
     * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0){
            return 0;
        }

        int size = prices.length;
        int holdIndex = 0;

        for (int i = 0; i < size -1; i ++) {

            if(prices[i] < prices[i+1]){
                holdIndex =  i;
                break;
            }

        }


        int out = 0;
        int in = 0;

        int hold = 0;
        int outIndex = 0;

        //最后一天无法完成买卖
        if(holdIndex == size-1){
            return 0;
        }

        for (int i = holdIndex; i < size; i++) {
            //买进
            if(hold == 0){
                out = prices[i];
                hold ++;
            }else{
                //卖出
                if(prices[i] > out){
                    outIndex = i;
                    in = prices[i] - out;
                    hold --;
                    break;
                }
            }
        }

        //买进
        if(hold == 0  && size-outIndex > 1){
            int[] left = new int[size-outIndex];
            System.arraycopy(prices,outIndex,left,0,size-outIndex);
            in += maxProfit(left);
        }

        return in;
    }

    public static void main(String[] args) {

        BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new BestTimeToBuyAndSellStockII();

        int[] a = new  int[]{7,1,5,3,6,4};

        int f = bestTimeToBuyAndSellStockII.maxProfit(a);

        System.out.println(f);
    }
}
