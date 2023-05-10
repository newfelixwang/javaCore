package com.wang.newcode.code;

/**
 * @Author：wp
 * @Package：com.wang.newcode.code
 * @Project：java-Core
 * @name：FindKthToTail
 * @Date：2023/5/5 15:41
 * @Filename：FindKthToTail
 */
public class FindKthToTail {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public static ListNode FindKthToTail(ListNode pHead, int k) {
        // write code here
        //双指针实现
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2.next = p2;
        }

        return p2;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        ListNode sss = listNode;
        ListNode s = FindKthToTail(listNode, 1);
        System.out.println(s);

        int int1  = 2147483647;
        int int2 = int1+1;
        int int3 = int1+2;
        System.out.println("##");
        System.out.println(int1);
        System.out.println(int2);
        System.out.println(int3);
    }

}






