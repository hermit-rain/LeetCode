/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //解法一
    public ListNode deleteNode(ListNode head, int val) {
        //首先判断头节点是否为待删除的节点
        if (head.val == val) {
            return head.next;
        }
        //定义辅助节点指向待删除节点的前一个节点
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return head;
    }

    //解法二
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        //递归终止的条件
        if (head.val == val) {
            return head.next;
        }
        //递归的操作
        head.next = deleteNode(head.next, val);
        return head;
    }
}