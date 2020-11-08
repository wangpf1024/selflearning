package com.sleflearning.leetcode;




/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
public class MinStack {

    private int[] list;
    private int size = 0;
    private int limit = 20;
    private int min =  Integer.MAX_VALUE;
    private int top = 0;

    /** initialize your data structure here. */
    public MinStack() {
        list = new int[limit];
    }

    public void push(int x) {
        if(size >= limit - 1){
            limit =  limit + 20;
            int[] newList = new int[limit];
            System.arraycopy(list,0,newList,0,size + 1);
            list = newList;
        }
        if(top == 0 ){
            min =  Integer.MAX_VALUE;
        }
        if(min > x){
            min = x;
        }
        top ++;
        list[top] = x;
        size ++;
    }

    public void pop() {
        if(top == 0 ){
            min =  Integer.MAX_VALUE;
            return;
        }
        int v = list[top];
        if(v <= min){
            min = list[top-1];
            for (int i = top-1; i > 0 ; i--) {
                if(min > list[i]){
                    min = list[i];
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
        return min;
    }

    public static void main(String[] args) {

        //["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
        //[[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
        //["MinStack","push","push","getMin","getMin","push","getMin","getMin","top","getMin","pop","push","push","getMin","push","pop","top","getMin","pop"]
        //[[],[-10],[14],[],[],[-20],[],[],[],[],[],[10],[-7],[],[-7],[],[],[],[]]
        //["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
        //[[],[2],[0],[3],[0],[],[],[],[],[],[],[]]

        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        obj.pop();
        System.out.println("min:"+obj.getMin());
        System.out.println("min:"+obj.top());

        System.out.println(2147483647);
        for (int i = 0; i < obj.size; i++) {

            System.out.println(obj.list[i]);
        }
        
    }
}
