# [剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

## 题目描述

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

**示例 1：**

```
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
```

**示例 2：**

```
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
```

**示例 3：**

```
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```

**提示：**

```
s.length <= 40000
```

## 解题思路

- 解法一：双指针+哈希表，通过遍历得到以每一个字符开头的最长字串的长度，左指针从下标为0的位置开始，右指针从下标为0的位置开始遍历。右指针右移，每遍历一个元素就将其添加至set集合中，当遇到已经存在集合中的元素或者右指针到达右边界，则跳出循环，保存以下标为0开始的最长无重复字符子串的长度，然后左指针右移动同时将当前元素移除set集合，继续遍历得到以下标为1开始的最长无重复子串的长度，动态更新最长返回值变量，直到左指针到达右边界则跳出外循环。


## 代码

<!-- tabs:start -->

### **Java**

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right - i);
        }
        return ans;
    }
}
```


### **...**

```

```

<!-- tabs:end -->