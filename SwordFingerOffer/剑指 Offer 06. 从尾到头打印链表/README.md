# [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

## 题目描述

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

**示例 1：**

```
输入：head = [1,3,2]
输出：[2,3,1]
```

**限制：**

```
0 <= 链表长度 <= 10000
```

## 解题思路

- 解法一：栈实现

  如果将单链表反转后再顺序输出将打破原链表的结构，我们可以运用栈后进先出的性质从头到尾遍历目标单链表，然后再依次弹出栈顶节点并将节点的值存入到返回数组中。

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public static int[] reversePrint(ListNode head) { 
        Stack<ListNode>stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop().val;
        }
        return res;        
    }
}
```


### **...**

```

```

<!-- tabs:end -->