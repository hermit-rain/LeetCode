class Solution {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}