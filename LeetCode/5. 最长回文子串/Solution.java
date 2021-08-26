class Solution {
    //解法一:暴力解法
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        int maxLen = 1; //最长回文子串的长度 -> 初始化为 1
        int beginIndex = 0; //最长回文串的起始下标 -> 初始化为 0
        char[] charArray = s.toCharArray();
        //暴力枚举出每一个回文子串并进行判断
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


    //解法二：动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        //定义动态方程 -> dp[i][j] -> 字符串 s 的第 i 到 j 个字母组成的子串是否为回文串
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        //l -> 字符串的长度,长度从 0-n 枚举子串,并判断是否为回文
        //枚举顺序为 00, 11 22  ... nn, 01, 12, 23, ... n-1 n, 012, 123, 234, ... n-2 n-1 n, ...
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) { //当子串长度为 1 时
                    dp[i][j] = true;
                } else if (l == 1) { //当子串长度为 2 时
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else { //当字串长度 >2 时
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1); //动态更新取最长的回文子串
                }
            }
        }
        return ans;
    }


}