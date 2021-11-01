# [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

## 题目描述

给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

**示例 1：**

```
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
```

**示例 2：**

```
输入：nums = [3,2,4], target = 6
输出：[1,2]
```

**示例 3：**

```
输入：nums = [3,3], target = 6
输出：[0,1]
```

**提示：**

- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- 只会存在一个有效答案

**进阶**：你可以想出一个时间复杂度小于 O(n2) 的算法吗？

## 解题思路

#### 解法一 哈希表

求数组中和为 target 的的两个元素的下标，我们最直观的想法是通过双层循环枚举的方式求解，但是这样时间复杂度为 O(n2) 太高了；

我们可以将题目变换下 -> 对于任一个元素 `nums[i]` , 返回 `nums` 数组中值为`target - num[i]` 元素的下标 ，利用哈希表的特性，通过一层循环，在遍历的过程中将 `nums[i]` 加入哈希表中同时判断， 这样就将 O(n) 时间复杂度降低到 O(1) 了

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
```

### **...**

```

```

<!-- tabs:end -->