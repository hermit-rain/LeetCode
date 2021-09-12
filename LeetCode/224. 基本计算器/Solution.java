class Solution {
    public int calculate(String s) {
        int len = s.length();
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        int res = 0, num = 0, op = 1;
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            //取出完整数值,包括多位数-> 直到遇到符号字符才向下执行
            if (temp >= '0' && temp <= '9') {
                num = num * 10 + (temp - '0');
                continue;
            }
            res += op * num;
            num = 0; //重置num
            if (temp == '+') op = stack.peek();
            else if (temp == '-') op = -stack.peek();
            else if (temp == '(') stack.push(op); //遇到'(' 则将当前的 op 入栈
            else if (temp == ')') stack.pop(); //遇到')' 弹栈
        }
        res += op * num; //如果最后一个字符是数字则不会走循环，需要单独加进来
        return res;
    }
}