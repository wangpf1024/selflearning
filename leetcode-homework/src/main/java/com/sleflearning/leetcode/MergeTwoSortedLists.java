package com.sleflearning.leetcode;


/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {






    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }



    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l4;

        ListNode l21 = new ListNode(1);
        ListNode l23 = new ListNode(3);
        ListNode l24 = new ListNode(4);

        l21.next = l23;
        l23.next = l24;


        ListNode  l3 = MergeTwoSortedLists.mergeTwoLists(l1,l21);

        while (l3.next != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }


    }
}
