# [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

## 题目描述	

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

**进阶：**

你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：

```
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]
```

示例 2：

```
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]
```

示例 3：

```
输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]
```

示例 4：

```
输入：head = [1], k = 1
输出：[1]
```

**提示：**

- 列表中节点的数量在范围 `sz` 内
- `1 <= sz <= 5000`
- `0 <= Node.val <= 1000`
- `1 <= k <= sz`

## 解题思路

#### 解法一  模拟

本题是在单个链表整体反转的基础上，按照k个一组进行反转，所以我们在每次反转之前需要通过 k 确定待反转链表的范围。

我们可以将链表分为已反转区域 + 待反转区域 + 未反转区域，每次将待反转的区域反转后再将这三个部分连接起来即可。关键即为如何正确的连接三个部分。

我们需要初始化两个变量 `pre` 和 `end` ，分别指向待反转链表的前驱 及 待反转链表的尾节点，待反转链表的头节点 `start = pre.next` 经过k次 循环，`end` 到达尾节点，记录待反转链表的后继 `next = end.next ` ,反转链表，然后将三个部分链表连接起来，重置 `pre`  `end` 指针，然后进入下一次循环...

当反转部分的长度不足 k 时，在定位完 `end` 后，已经到达末尾，表示已经完成反转，直接返回即可~

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; 
        ListNode end = dummy; 
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next; 
            if (end == null) break;
            ListNode start = pre.next; 
            ListNode next = end.next; 
            end.next = null;
            pre.next = reverse(start); 
            start.next = next;
            pre = start; 
            end = start; 
        }
        return dummy.next;
    }

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
```

### **...**

```

```

<!-- tabs:end -->