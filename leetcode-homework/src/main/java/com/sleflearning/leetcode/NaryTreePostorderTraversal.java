package com.sleflearning.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * N 叉树后续遍历
 */
public class NaryTreePostorderTraversal {


   private List<Integer> list = new ArrayList<Integer>(1000);


    //左 - > 右 -> 根

    public List<Integer> postorder(Node root) {

        if(root == null){
            return list;
        }

        if(root.children == null){

            list.add(root.val);

            return list;
        }


        for (int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }

        list.add(root.val);

        return list;
    }

    // 前序顺序遍历
    // https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

    public List<Integer> preorder(Node root) {

        if(root == null){
            return list;
        }

        list.add(root.val);

        if(root.children == null){

            return list;
        }


        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i));
        }


        return list;
    }



    public static void main(String[] args) {


        Node node5 = new Node(5);

        Node node6 = new Node(6);

        List<Node> list2 = new ArrayList<Node>();
        list2.add(node5);
        list2.add(node6);

        Node node3 = new Node(3,list2);

        Node node2 = new Node(2);

        Node node4 = new Node(4);

        List<Node> list = new ArrayList<Node>();
        list.add(node3);
        list.add(node2);
        list.add(node4);



        Node node = new Node(1,list);


        NaryTreePostorderTraversal naryTreePostorderTraversal = new NaryTreePostorderTraversal();


        List<Integer> v = naryTreePostorderTraversal.preorder(node);

        System.out.println(v);
    }


}
