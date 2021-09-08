//解法一：横向遍历
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
//解法二：纵向扫描
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { //得到数组中最短字符串的长度
            len = Math.min(len, strs[i].length());
        }
        boolean flag = true; //标志位
        int i = 0;
        while (i < len) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < n; j++) { //逐个字符按位比较
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
