# [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

## 题目描述

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 

**示例 1：**

```
输入：[3,4,5,1,2]
输出：1
```

**示例 2：**

```
输入：[2,2,2,0,1]
输出：0
```

## 解题思路

- 解法一：二分查找，通过分析我们发现如果数组没有经过旋转，那么最小值即为第一个元素。如果数组经过了旋转，那么最小值左侧为递增序列，最小值右侧也为递增序列。其中数组的最后一个元素即为旋转点，最小值左侧元素全部大于旋转点，最小值右侧全部小于旋转点，我们可以根据这一特性进行二分查找。

  如果中点值大于旋转点，那么最小值在中点右侧，更新左边界；如果中点值小于旋转点那么最小值在中点值左侧，更新右边界；如果中点值等于旋转点那么此时无法准确判断最小值和中点值的关系就不能盲目更新边界，将右边界左移一位即可。当左右边界的下标相差为1时，此时右边界的位置即为最小值。

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int minArray(int[] numbers) {
        if (numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        int left = 0;
        int right = numbers.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            int midVal = numbers[mid];
            if (midVal > numbers[right]) left = mid;
            else if (midVal < numbers[right]) right = mid;
            else right--;
        }
        return numbers[right];
    }
}
```


### **...**

```

```

<!-- tabs:end -->