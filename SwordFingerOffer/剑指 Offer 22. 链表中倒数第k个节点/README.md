# [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

## 题目描述

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

**示例 1：**

```
给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
```

## 解题思路

- 解法一：先求链表长度length ，然后定义辅助指针 res 从头开始遍历，共走(length - k) 步，此时res的指向即为倒数第k个节点。

- 解法二：快慢双指针。我们可以定义两个辅助指针分别表示快慢指针，快指针先走k步，然后快慢指针一起走，当快指针走过整个链表时，慢指针刚好指向倒数第k个节点，返回慢指针即可。

  

  

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = getLength(head);
        if (k <= 0 || k > size) {
            return null;
        }
        ListNode res = head;
        for (int i = 0; i < size - k; i++) {
            res = res.next;
        }
        return res;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
```

**解法二**

```java
class Solution {
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
```




### **...**

```

```

<!-- tabs:end -->