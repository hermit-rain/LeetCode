# [14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/)

## 题目描述

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 `""`。

**示例 1：**

```
输入：strs = ["flower","flow","flight"]
输出："fl"
```

**示例 2：**

```
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
```

**提示：**

- `1 <= strs.length <= 200`
- `0 <= strs[i].length <= 200`
- `strs[i]` 仅由小写英文字母组成

## 解题思路

#### 解法一  横向遍历

求字符串数组中的所有字符串的最长公共前缀，我们可以以第一个字符串为基准字符并依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀，当遍历完所有的字符串以后，即可得到字符串数组中的最长公共前缀。

#### 解法二  纵向扫描

以首个字符串为基准字符串，定义一个索引指针指向其首个字符，循环遍历比较数组中其余字符串相同位置的字符，当出现不同时就跳出循环并根据索引返回最长公共前缀

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int n = strs.length;
        String resStr = strs[0];
        for (int i = 0; i < n; i++) {
            resStr = longestCommonPrefix(resStr, strs[i]);
            if (resStr.length() == 0) {
                break;
            }
        }
        return resStr;
    }

    /**
     * 返回两个字符串的最长公共前缀
     *
     * @param s1 输入字符串s1
     * @param s2 输入字符串s2
     * @return 输出最长公共前缀
     */
    public String longestCommonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < len && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }
}
```

**解法二**

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            len = Math.min(len, strs[i].length());
        }
        boolean flag = true;
        int i = 0;
        while (i < len) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) != temp) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
            i++;
        }
        return strs[0].substring(0, i);
    }
}
```

### **...**

```

```

<!-- tabs:end -->