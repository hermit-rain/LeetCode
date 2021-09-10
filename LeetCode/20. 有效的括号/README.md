# [20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)

## 题目描述	


给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串 `s` ，判断字符串是否有效。

有效字符串需满足：

1. 左括号必须用相同类型的右括号闭合。
2. 左括号必须以正确的顺序闭合。

**示例 1：**

```
输入：s = "()"
输出：true
```

**示例 2：**

```
输入：s = "()[]{}"
输出：true
```

**示例 3：**

```
输入：s = "(]"
输出：false
```

**示例 4：**

```
输入：s = "([)]"
输出：false
```

**示例 5：**

```
输入：s = "{[]}"
输出：true
```

**提示：**

- `1 <= s.length <= 104`
- `s` 仅由括号 `'()[]{}'` 组成

## 解题思路

#### 解法一  栈

根据本题中给出的有效字符串的条件，我们可以根据栈后入先出的特性来进行模拟判断

逐个遍历字符串中的每一个字符，如果当前字符类型为"右括号"，则将其与栈顶元素比较，如果栈顶元素为与之匹配的"左括号" 则出栈；如果当前字符为"左括号" 则直接入栈，最后遍历完所有字符后判断栈是否为空，如果栈为空则为有效的括号~

**优化：** 当前字符类型为"右括号"，并且与栈顶元素不匹配，那么其就永远也无法出栈。可直接跳出循环直接返回 false；

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                if (!stack.isEmpty() && stack.peek() == map.get(temp)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}
```

### **...**

```

```

<!-- tabs:end -->