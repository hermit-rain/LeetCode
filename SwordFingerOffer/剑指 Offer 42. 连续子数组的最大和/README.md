# [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

## 题目描述

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

**示例 1：**

```
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。3
```

**提示：**

- `1 <= arr.length <= 10^5`
- `-100 <= arr[i] <= 100`

## 解题思路

解法一：动态规划，

**状态定义：** 设动态规划列表`dp`,`dp[i]` 代表以以 元素 `nums[i] `为结尾的连续子数组的最大和；

**转移方程：** 

- `dp[i - 1]` > 0 时：执行`dp[i]` = `dp[i - 1] `+ `nums[i]`;
- `dp[i - 1]` < 0 时 ： 执行`dp[i]` = `nums[i]`;

**初始状态：** `dp[0]` =`nums[0]`, 即以 `nums[0]` 结尾的连续子数组最大和为 `nums[0]`;

**返回值：** 返回`dp`列表中的最大值；

**空间复杂度降低：** 

- 由于`dp[i]` 只与 `dp[i - 1] `和 `nums[i]` 有关系，因此可以将原数组 `nums` 用作`dp` 列表，即直接在 `nums` 上进行修改;
- 由于省去了`dp` 列表使用的额外空间，因此空间复杂度从 O(N) 降至 O(1);

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
```


### **...**

```

```

<!-- tabs:end -->