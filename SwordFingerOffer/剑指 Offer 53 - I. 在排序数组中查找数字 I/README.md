# [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

## 题目描述

统计一个数字在排序数组中出现的次数

**示例 1：**

```
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
```

**示例 2：**

```
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
```

**限制：**

```
0 <= 数组长度 <= 50000
```

## 解题思路

- 解法一：全盘遍历

- 解法二：二分查找后左右扫描

  数组是顺序的并且同一数字在数组中出现的位置连续集中在某一区域，全盘扫描时间复杂度太高。我们可以先用二分查找找到待统计数字的下标，然后从该下标开始分别向左向右扫描，一旦遇到非待统计数字或到达边界就跳出遍历。
  
  

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public int search(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
}
```

**解法二**

```java
class Solution {
    public int search(int[] nums, int target) {
        int midIndex = binarySearch(nums, 0, nums.length - 1, target);
        if (midIndex == -1) {
            return 0;
        }
        int count = 1;
        int temp = midIndex - 1;
        while (true) {
            if (temp < 0 || nums[temp] != target) {
                break;
            }
            count++;
            temp--;
        }
        temp = midIndex + 1;
        while (true) {
            if ( temp > nums.length - 1 || nums[temp] != target) {
                break;
            }
            count++;
            temp++;
        }
        return count;
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
```




### **...**

```

```

<!-- tabs:end -->