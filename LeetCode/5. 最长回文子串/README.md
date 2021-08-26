# [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

## 题目描述

给你一个字符串 `s`，找到 `s` 中最长的回文子串。

**示例 1：**

```
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
```

**示例 2：**

```
输入：s = "cbbd"
输出："bb"
```

**示例 3：**

```
输入：s = "a"
输出："a"
```

**示例 4：**

```
输入：s = "ac"
输出："a"
```

**提示：**

- `1 <= s.length <= 1000`
- `s` 仅由数字和英文字母（大写和/或小写）组成

## 解题思路

#### 解法一  暴力解法

枚举出所有的子串，判断是否为回文串，并将长度最大的回文串返回；

#### 解法二  动态规划

如果一个长度大于2的子串是回文串，那么将它首尾的两个字母去除之后，它仍然是个回文串。-> aba - b ，abba - bb；根据这样的规则我们可以通过动态规划的方式进行求解

**状态定义**：设动态规划列表 dp，` dp[i][j]` 表示字符串 s 的第 i 到 j 个字母组成的子串是否为回文串

**转移方程**：`dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])`

**初始化** : `boolean[][] dp = new boolean[n][n]`

以上都是在字符串长度大于2的情况下判断的，子串长度为1 和 2 的判断如下：

- `dp[i][i] = true` -> 子串长度为1 一定是回文串
- `dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1))` -> 子串长度为 2 则判断两个字符是否相等

**注意：** 在状态转移方程中，我们是**从长度较短的字符串向长度较长的字符串进行转移**的，这也是同暴力解法的区别之一；

## 相关知识

- 子串(substring) ：原始字符串的一个**连续**子集
- 子序列(subsequence) : 原始字符串的一个子集
- `str.substring(2,7) -> [2, 7)  , str,substring(2) -> [2, str.length())`

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1; 
        int beginIndex = 0; 
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindrome(charArray, i, j)) {
                    maxLen = j - i + 1;
                    beginIndex = i;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    /**
     * 判断指定范围的字符数组是否为回文串
     *
     * @param charArray 输入字符数组
     * @param left      字符左边界
     * @param right     字符右边界
     * @return 回文串则返回 true,否则返回 false
     */
    private boolean isPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
```

**解法二**

```java
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) { 
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) { 
                    dp[i][j] = true;
                } else if (l == 1) { 
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else { 
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1); 
                }
            }
        }
        return ans;
    }
}
```

### **...**

```

```

<!-- tabs:end -->