class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int right = 0, ans = 0; //右指针起始位置 0
        //从头到尾比遍历左指针-->得到以每一个字符开头的最长连续字串长度
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //左指针每次移动则移除左边界字符
                set.remove(s.charAt(i - 1));
            }
            //右指针向右遍历逐渐加入不重复的字符
            while (right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                ++right;
            }
            //动态调整ans -> 最长非重复子串的长度
            ans = Math.max(ans, right - i);
        }
        return ans;

    }
}