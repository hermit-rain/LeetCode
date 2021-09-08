# [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

## 题目描述	

给你一个单链表的头节点 `head` ，请你判断该链表是否为回文链表。如果是，返回 `true` ；否则，返回 `false` 。

**示例 1：**

![img](https://assets.leetcode.com/uploads/2021/03/03/pal1linked-list.jpg)

```
输入：head = [1,2,2,1]
输出：true
```

**示例 2：**

![img](https://assets.leetcode.com/uploads/2021/03/03/pal2linked-list.jpg)

```
输入：head = [1,2]
输出：false
```

## 解题思路

#### 解法一  双指针

我们先遍历链表，将节点的值依次存入到集合中，然后定义双指针分别指向集合数组的头和尾，前后扫描比较即可。

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
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
```

### **...**

```

```

<!-- tabs:end -->