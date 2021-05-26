# [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

## 题目描述

输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

**示例 1：**

```
输入: "the sky is blue"
输出: "blue is sky the"
```

**示例 2：**

```
输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
```

**示例 3：**

```
输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

**说明：**

```
无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
```

## 解题思路

- 解法一：双指针，首先处理字符串去除两边的空格，定义两个指针同时指向字符串尾，左指针左移，遇到空格就将经过的字符取出并存入StringBuilder 中,然后跨过空格路径，更新右指针的位置，继续上述操作，直到左指针到达左侧边界跳出循环。此时再将StringBuilder 转化成 String 输出即可。
- 解法二：转化成数组再逆序输出，但是在变成数组时候由于单词间可能包括多个空格的情况，所以我们在输出时做判断，只将单词输出保存即可。

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return res.toString().trim();
    }
}
```

**解法二**

```java
class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            }
            res.append(str[i] + " ");
        }
        return res.toString().trim();
    }
}
```

### **...**

```

```

<!-- tabs:end -->