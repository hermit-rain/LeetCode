# [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

## 题目描述

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

**示例 1：**

```
s = "abaccdeff"
返回 "b"

s = "" 
返回 " "
```

**限制：**

```
0 <= s 的长度 <= 50000
```

## 解题思路

- 解法一：哈希表，定义一个哈希表第一次遍历统计每个字符出现的个数，第二次遍历找到第一个只出现一次的字符并返回。


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (char key : arr) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }
}
```


### **...**

```

```

<!-- tabs:end -->