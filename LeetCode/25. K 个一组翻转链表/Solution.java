/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; //待反转链表的前驱
        ListNode end = dummy; //待反转链表的尾节点
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next; //定位尾节点
            if (end == null) break;
            ListNode start = pre.next; //待反转链表的头节点
            ListNode next = end.next; // 待反转链表的后继
            end.next = null;
            pre.next = reverse(start); //将当前待反转区域反转
            start.next = next; //将当前已反转的区域与后面你未反转的区域连接
            pre = start; //重定位前驱
            end = start; //重定位尾节点
        }
        return dummy.next;
    }

    //头插法-反转单链表
    public ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}