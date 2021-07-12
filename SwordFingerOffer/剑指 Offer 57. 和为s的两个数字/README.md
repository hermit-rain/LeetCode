# [剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

## 题目描述

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

**示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
```

**示例 2：**

```
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]
```

## 解题思路

- 解法一：双指针，定义双指针 i,j 分别指向数组的头和尾，判断sum = nums[i] + nums[j] 与 target的关系，如果sum > target，则将右指针j左移，如果sum < target 则将左指针右移，如果相等则直接返回双指针所对应的元素即可。


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) i++;
            else if (sum > target) j--;
            else return new int[]{nums[i], nums[j]};
        }
        return new int[0];
    }
}
```


### **...**

```

```

<!-- tabs:end -->