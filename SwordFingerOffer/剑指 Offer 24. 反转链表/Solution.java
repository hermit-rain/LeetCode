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
    public ListNode reverseList(ListNode head) {
        //如果链表为空或者只有一个节点则无需反转，直接返回
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个辅助指针（变量）， 帮助遍历原来的了链表
        ListNode cur = head;
        //指向cur的下一个节点 初始值为null
        ListNode next = null;
        //定义一个新的链表头用于接收反转后的节点
        ListNode newList  = new ListNode(0);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverseHead 的最前端
        while (cur != null) {
            next = cur.next;
            //第一次循环将cur的next域置为空，之后循环将reverseHead的节点连接到cur节点上
            cur.next = newList.next;
            newList.next = cur; //将cur连接到新的链表头上
            cur = next; //让cur后移
        }
        //将链表头替换为原表头
        head = newList.next;
        return head;
    }

    //解法二
    public ListNode reverseList(ListNode head) {
        //递归退出的条件
        if (head == null || head.next == null) {
            return head;
        }
        //从头节点逐渐递归到尾节点
        ListNode newHead = reverseList(head.next);
        //递的过程结束后开始向上归并反转
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}