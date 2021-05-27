# [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

## 题目描述

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

**示例 1：**

```
输入: s = "abcdefg", k = 2
输出: "cdefgab"
```

**示例 2：**

```
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"
```

**说明：**

```
1 <= k < s.length <= 10000
```

## 解题思路

- 解法一：字符串拼接，我们直接用String类的substring方法，将两段子字符串取出然后直接用 "+" 拼接即可。

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
```

### **...**

```

```

<!-- tabs:end -->