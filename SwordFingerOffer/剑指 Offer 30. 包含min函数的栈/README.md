# [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

## 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)

**示例 1：**

```
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.
```

**提示：**

```
各函数的调用总次数不超过 20000 次
```

## 解题思路

- 解法一：辅助栈，本题的关键在于实现一个时间复杂度为O(1) 的返回栈的最小元素的方法min(),如果直接遍历栈中元素返回最小元素其时间复杂度为O(N)，所以需要定义一个辅助栈来保存"非严格降序的元素"。同时**保证辅助栈中的栈顶元素永远对应于原栈中的最小元素**，当调用min()方法时候，只需要弹出辅助栈的栈顶元素即可。

| 函数设计 |                  stack1                   |                        stack2(辅助栈)                        |
| :------: | :---------------------------------------: | :----------------------------------------------------------: |
| push(x)  |    将元素压入stack1 -> stack1.push(x)     | 若stack2为空或者x**小于等于**stack2的栈顶元素 -> stack2.push(x) |
|   pop    |     将元素弹出stack1 -> stack1.pop()      | 若stack1.pop() 出栈元素的值等于stack2的栈顶元素-> stack2.pop() |
|   top    | 直接返回stack1的栈顶元素 -> stack1.peek() |                             null                             |
|   min    |                   null                    |          直接返回stack2的栈顶元素 -> stack2.peek()           |

<!-- tabs:start -->

### **Java**

**解法一**

```java
class MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
```

### **...**

```

```

<!-- tabs:end -->