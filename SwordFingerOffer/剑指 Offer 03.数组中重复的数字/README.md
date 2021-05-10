# [面试题 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

## 题目描述

找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0 ～ n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

**示例 1：**

```
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3
```

**限制：**

```
2 <= n <= 100000
```

## 解题思路

- 解法一：遍历数组

  由于只需要找出数组中任意一个重复的数字，因此遍历数组，遇到重复的数字即返回。利用set集合元素不可重复的特性，遍历数组并加入集合，当add方法返回false，表示集合中已经存在该数字则直接返回，否则返回-1。

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
```


### **...**

```

```

<!-- tabs:end -->