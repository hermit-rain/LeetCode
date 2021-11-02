class Solution {
    //解法一
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; i++) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) return 1;
            if (x < y) return -1;
        }
        return 0;
    }

    //解法二
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0, y = 0;
            while (i < n && version1.charAt(i) != '.') {
                x = x * 10 + version1.charAt(i) - '0';
                i++;
            }
            while (j < m && version2.charAt(j) != '.') {
                y = y * 10 + version2.charAt(j) - '0';
                j++;
            }
            if (x != y) {
                return x > y ? 1 : -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}