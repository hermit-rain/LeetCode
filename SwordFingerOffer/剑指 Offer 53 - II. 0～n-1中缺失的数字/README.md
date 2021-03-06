# [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

## 题目描述

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

**示例 1：**

```
输入: [0,1,3]
输出: 2
```

**示例 2：**

```
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
```

**限制：**

```
1 <= 数组长度 <= 10000
```

## 解题思路

- 解法一：全盘遍历

  在未缺失数字的情况下即范围 0～n-1 的数字都在数组内，那么数字的下标索引与其对应的元素值都是相等的。当有有一个数字缺失时，我们可以通过将下标和数值进行依次遍历比较，当不相等时即跳出遍历。

- 解法二：二分查找

  通过分析我们可以发现在缺失的数字之前数组的索引下标和其数值是一一对应的，在缺失的数字之后出现错位。我们通过二分查找找到错位点即可。定义左右两个指针起始分别指向数组的边界，通过判断中心索引与中心数值的关系来决定左右指针的移动。当中心索引与中心值相等时说明缺失数字在中心索引右侧,移动左指针到中心点右侧。当中心索引与其对应的数值不相等时，说明缺失数字在中心点左侧，更新右指针到中心点左侧。直到左指针大于右指针就跳出循环。此时左指针索引值即为缺失的数字。(注意缺失数字在数组边界的情况)
  
  

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public int missingNumber(int[] nums) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                break;
            }
        }
        return i;
    }
}
```

**解法二**

```java
class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;  
        int r = nums.length - 1; 
        while (l <= r) { 
            int mid = (l + r) / 2;
            if (mid == nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
```




### **...**

```

```

<!-- tabs:end -->