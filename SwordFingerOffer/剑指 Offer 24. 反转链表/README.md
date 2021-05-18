# [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

## 题目描述

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

**示例 1：**

```
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```

## 解题思路

- 解法一：头插法，定义一个新的链表头作为辅助链表，从头遍历原来的链表，每遍历一个节点就将其取出并放入到新建链表的头部。遍历结束后将新链表再重新接到原链表处并返回原链表的头节点即可。

- 解法二：递归，共分为递进和归并两步。先从头节点开始逐渐递进到尾节点，该尾节点就是反转后的头节点。递的过程结束后开始向上归并反转，每次反转操作包括1.让当前节点的下一个节点的next指针指向当前节点 2.让当前节点的next指针指向null，从而实现从链表尾部开始局部反转。当递归函数全部出栈后，链表反转完成。


## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode next = null;
        ListNode newHead = new ListNode(0);
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        head = newHead.next;
        return head;
    }
}
```

**解法二**

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```




### **...**

```

```

<!-- tabs:end -->