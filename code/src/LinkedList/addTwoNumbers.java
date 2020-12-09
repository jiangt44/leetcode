package LinkedList;

import common.ListNode;

public class addTwoNumbers {
    /**
     * leetcode 第二题 两数之和
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 考虑点：1、进1位；2、当最后一位进一的时候，需要补充一个节点；3、长度相等时，如何
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        int temp = 0;
        ListNode l;
        int sum  = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + temp;
            l2.val = l1.val = sum % 10;
            temp = sum / 10;
            if (l1.next == null && l2.next == null) {
                if (temp == 1) {
                    l2.next = new ListNode(1);
                    return h2;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        l = l1 == null ? l2 : l1;
        while (temp != 0 && l != null) {
            sum = l.val + temp;
            temp = sum / 10;
            l.val = sum % 10;
            if (l.next == null) break;
            l = l.next;
        }
        if (temp != 0) {
            l.next = new ListNode(1);
        }
        return l1 == null ? h2 : h1;
    }
}
