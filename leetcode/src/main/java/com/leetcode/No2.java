package com.leetcode;

import com.leetcode.bean.ListNode;
import com.sun.org.apache.regexp.internal.REUtil;

/**
 * Created by Administrator on 2018/9/25.
 */
public class No2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode current = result;
        int carryFlag = 0;

        while (l1 != null || l2 != null) {

            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;

            current.next = new ListNode((l1Val + l2Val + carryFlag) % 10);
            carryFlag = l1Val + l2Val + carryFlag >= 10 ? 1 : 0;
            current = current.next;

        }
        if (carryFlag == 1) {
            ListNode carry = new ListNode(1);
            current.next = carry;
        }
        return result.next;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        ListNode r3 = new ListNode(6);
        r1.next = r2;
        r2.next = r3;

        ListNode result = new No2().addTwoNumbers(l1, r1);
        System.out.println(result);

    }
}
