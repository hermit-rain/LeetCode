class Solution {
    //解法一
    public String reverseWords(String s) {
        //删除首尾空白符号
        s = s.trim();
        int i = s.length() - 1, j = s.length() - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            //提取子字符串 => 从索引 i + 1 到 j
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        //将.toString() ==> StringBuilder -> String 类型
        //.trim() ==> StringBuffer转换成String类型时 没有用.trim()会导致意想不到的结果
        return res.toString().trim();
    }

    //解法二
    public String reverseWords(String s) {
        //将字符串去除两边空格并按照空格转化成数组
        String[] str = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        //从右向左遍历数组当遇到空内容就跳出当前循环，否则将单词加入到 StringBuilder 中
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i].equals("")) {
                continue;
            }
            res.append(str[i] + " ");
        }
        //返回String 类型对象
        return res.toString().trim();
    }

}