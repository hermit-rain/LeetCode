# [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

## 题目描述

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

**示例 1：**

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2：**

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

**提示：**

```
1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
```

## 解题思路

- 解法一：模拟队列的实现本质上是实现队列先入先出的性质，由于栈后入先出的特性我们只能使用两个栈stack1，stack2来实现，其中stack1实现入队列操作，stack2实现出队列的操作。入队列操作时只需要将元素压入stack1即可，出队列操作时，待删除元素为stack1的栈底元素，此时需要将stack1中的元素全部弹出并压入到stack2中，此时stack2的栈顶元素即为待删除元素，直接弹出即可。注意：在删除操作时需要考虑stack2是否为空的情况，如果为空则将stack1中元素压入stack2中执行上述操作，否则直接弹出栈顶元素即可。

## 代码

<!-- tabs:start -->

### **Java**

**解法一**

```java
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            return -1;
        }
    }
}
```

### **...**

```

```

<!-- tabs:end -->