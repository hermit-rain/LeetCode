# [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

## 题目描述

将两个升序链表合并为一个新的 **升序** 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

**示例 1：**

```
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
```

**示例 2：**

```
输入：l1 = [], l2 = []
输出：[]
```

**示例 3：**

```
输入：l1 = [], l2 = [0]
输出：[0]
```

**提示：**

- 两个链表的节点数目范围是 `[0, 50]`
- `-100 <= Node.val <= 100`
- `l1` 和 `l2` 均按 **非递减顺序** 排列

## 解题思路

#### 解法一 迭代遍历

两个链表是升序链表，我们可以利用归并排序的思想，从两个链表的头节点开始依次比较它们的大小，并将较小的节点接到一个新链表上。当两条链表其中一个为空时跳出遍历，并将非空链表的剩余节点直接接到新链表尾即可，最后返回新链表；

#### 解法二 递归

**递归终止条件** ：当两个链表都为空时，表示我们对链表已合并完成。

**递归**：判断 l1和 l2 的头节点大小， 如果 l1 < l2 ，那就将 l1.next 与 l2 的合并结果接到 l1 节点后面，否则就将 l1 与 l2.next 的合并结果接到 l2后面； 

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
```

**解法二**

```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->