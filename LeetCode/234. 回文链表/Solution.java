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
    public boolean isPalindrome(ListNode head) {
        //将节点的值添加到集合数组中
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        //判断是否为回文
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (list.get(l) != list.get(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}