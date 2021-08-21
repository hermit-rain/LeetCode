# [415. 字符串相加](https://leetcode-cn.com/problems/add-strings/)

## 题目描述

给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。



**提示：**

num1 和num2 的长度都小于 5100
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式

## 解题思路

- 解法一：模拟计算 ，通过题意我们最直观的想法就是将两个字符串转换成整数的形式，然后通过将两个整数相加再返回其字符串的形式。这样仅仅适用于字符串长度较小的的情况，如果字符串表示的整数很大的话，即使是long 整型在相加之后也会超出数值范围。

  那么我们可以将两个字符串的相加模拟成在纸上对两个整数进行按位相加，竖对齐，前面空位用0补位，定义一个变量用来存储进位，定义两个指针分别从两个字符串的末尾向前移动，将每个数位上的计算结果存储在 StringBuffer 中，最后再反转字符串即可。

## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0; 
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + add;
            res.append(temp % 10);
            add = temp / 10;
            i--;
            j--;
        }
        res.reverse(); 
        return res.toString();
    }
}
```


### **...**

```

```

<!-- tabs:end -->