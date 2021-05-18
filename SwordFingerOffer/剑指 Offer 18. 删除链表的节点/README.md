# [剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

## 题目描述

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

返回删除后的链表的头节点。

**注意：**此题对比原题有改动

**示例 1：**

```
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
```

**示例 2：**

```
输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
```

**说明：**

```
题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
```

## 解题思路

- 解法一：单指针，定义辅助指针cur，从头开始遍历找到待删除节点前一个节点,并执行删除操作。
- 解法二：递归，递归的终止条件为 1.已经递进到链表的尾 2.当前的节点为待删除节点。然会逐渐向上进行归并操作，每次归并操作1.将当前节点指向其下一个节点，遇到待删除节点时候指向其下下一个节点 2. 返回当前节点。归并结束后即返回删除后的链表头节点。

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
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
}
```

**解法二**

```java
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }
}
```



### **...**

```

```

<!-- tabs:end -->