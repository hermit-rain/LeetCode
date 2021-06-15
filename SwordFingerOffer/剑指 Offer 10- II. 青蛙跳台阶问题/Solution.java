class Solution {
    //解法一
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    //解法二
    public int numWays(int n) {
        int maxNum = n + 2;
        int[] f = new int[maxNum];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxNum; i++) {
            f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
        }
        return f[n];
    }
}