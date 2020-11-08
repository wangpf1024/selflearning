package com.sleflearning.leetcode;




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack2 {

    private int[] list;
    private int size = 0;
    private int limit = 20;
    private int[] min;
    private int minTop = 0;
    private int minSize = 0;
    private int minIdx = 0;
    private int top = 0;

    /** initialize your data structure here. */
    public MinStack2() {
        list = new int[limit];
        min = new int[limit];
    }

    public void push(int x) {
        if(size >= limit - 1){
            limit =  limit + 20;
            int[] newList = new int[limit];
            System.arraycopy(list,0,newList,0,size + 1);
            list = newList;
        }
        if(minSize >= limit - 1){
            limit =  limit + 20;
            int[] newList = new int[limit];
            System.arraycopy(min,0,newList,0,minSize + 1);
            min = newList;
        }

        if(top == 0 ){
            min[minTop] = Integer.MAX_VALUE;
        }

        top ++;
        list[top] = x;
        size ++;

        if(min[minTop] > x){
            minTop ++ ;
            min[minTop] = x;
            minSize ++;
            minIdx = top;
        }

    }

    public void pop() {
        if(top == 0 ){
            return;
        }
        if(minIdx == top){
            minTop = 0;
            minSize = 0;
            min[minTop] = Integer.MAX_VALUE;
            for (int i = top - 1; i > 0; i --) {
                if( min[minTop] > list[i]){
                    minTop ++ ;
                    min[minTop] = list[i];
                    minSize ++;
                    minIdx = i;
                }
            }
        }
        top --;
        size --;
    }

    public int top() {
        return list[top];
    }

    public int getMin() {
        return min[minTop];
    }

    public static void main(String[] args) {

        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        //["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
        //[[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
        //["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]

        MinStack2 obj = new MinStack2();
        obj.push(2);
        obj.push(0);
        obj.push(3);
        obj.push(0);
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println("min:"+obj.getMin());



    }
}
