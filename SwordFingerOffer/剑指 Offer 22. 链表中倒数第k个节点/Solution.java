/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    //解法一
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = getLength(head);
        //k值的校验
        if (k <= 0 || k > size) {
            return null;
        }
        ListNode res = head;
        //找到倒数第k个节点 => 第 size - k 位置处
        for (int i = 0; i < size - k; i++) {
            res = res.next;
        }
        return res;
    }

    //返回链表的长度=>有效的节点数
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    //解法二
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}