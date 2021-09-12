# [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/)

## 题目描述	

给你一个字符串表达式 `s` ，请你实现一个基本计算器来计算并返回它的值。

**示例 1：**

```
输入：s = "1 + 1"
输出：2
```

**示例 2：**

```
输入：s = " 2-1 + 2 "
输出：3
```

**示例 3：**

```
输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
```

**提示：**

- `1 <= s.length <= 3 * 105`
- `s` 由数字、`'+'`、`'-'`、`'('`、`')'`、和 `' '` 组成
- `s` 表示一个有效的表达式

## 解题思路

#### 解法一 括号展开 + 栈

我们可以用最基本的计算思想来将括号展开 -> 例如 2 -（1 - 3）展开成 2 - 1 + 3， 通过 一个 op (-1或者1) 的标志符来转换加减法运算 

即 2 - 1 + 3 ==>  2 + (-1) + 3 。

括号的问题通过栈来维护 -> 当遇到'(' 时候将当前 op 入栈，遇到 ')' 则将将栈顶元素弹栈，每个栈顶元素只应用与当前括号内的运算操作，并根据 '+' 或者 '-' 符号来动态的调整。

整个执行顺序为 先取数再根据 op 进行加法计算，遇到符号位再变号。

## 代码

<!-- tabs:start -->

#### Java

**解法一**

```java
class Solution {
    public int calculate(String s) {
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int res = 0, num = 0, op = 1;
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (temp >= '0' && temp <= '9') {
                num = num * 10 + (temp - '0');
                continue;
            }
            res += op * num;
            num = 0; 
            if (temp == '+') op = stack.peek();
            else if (temp == '-') op = -stack.peek();
            else if (temp == '(') stack.push(op); 
            else if (temp == ')') stack.pop(); 
        }
        res += op * num; 
        return res;
    }
}
```

### **...**

```

```

<!-- tabs:end -->