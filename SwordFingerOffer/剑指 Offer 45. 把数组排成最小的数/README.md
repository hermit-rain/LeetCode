# [剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

## 题目描述

输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

**示例 1：**

```
输入: [10,2]
输出: "102"
```

**示例 2：**

```
输入: [3,30,34,5,9]
输出: "3033459"
```

**提示：**

```
0 < nums.length <= 100
```

**说明：**

- 输出结果可能非常大，所以你需要返回一个字符串而不是整数
- 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0

## 解题思路

- 解法一：排序，该题的本质就是排序，只不过并不是将每一个元素按照顺序(或逆序) 进行排序。因为要保证最后拼接的字符数最小，根据字符的ASCLL码的存储规则，我们发现如果保证任意相邻的两个元素 **前者 + 后者 < 后者 + 前者** 这样的规则，那么拼接成的字符串就是最小的，即 3 + 30 = 330 > 30 + 3 = 303  --> 就需要交换 3 与 30 。

  我们根据特定规则进行冒泡排序，最后在通过String的`replaceAll()` 借助正则表达式将输出数组中的"**[]**" 与 "**,**" 替换掉即可。

  

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public String minNumber(int[] nums) {
        bubbleSort(nums);
        return Arrays.toString(nums).replaceAll("\\[|]|,|\\s", "");
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (("" + arr[j] + arr[j + 1]).compareTo("" + arr[j + 1] + arr[j]) > 0) {
                    flag = true;
                    arr[j + 1] = arr[j] + arr[j + 1];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
```


### **...**

```

```

<!-- tabs:end -->