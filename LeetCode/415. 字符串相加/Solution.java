class Solution {
    public String addStrings(String num1, String num2) {
        StringBuffer res = new StringBuffer();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int add = 0; // add -> 进位 初始为 0
        while (i >= 0 || j >= 0 || add != 0) {
            // num1.charAt(i) - '0' --> 字符存储是以ASCll码的形式存储的
            //通过相减少就可以返回该数字字符对应的整型数值了
            //当指针已经向左越过起点字符的时候-> 用 0 补位
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x + y + add;
            res.append(temp % 10);
            add = temp / 10;
            i--;
            j--;
        }
        res.reverse(); //反转字符
        return res.toString();
    }
}