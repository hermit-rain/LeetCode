class Solution {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 0; //定义返回值 总的糖果数 -> 初始化为0
        int[] res = new int[n];
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && res[i] <= res[i + 1]) {
                res[i] = res[i + 1] + 1;
            }
            sum += res[i];
        }
        //更新 sum -> 加基准值(每个孩子至少一个) 、加上面循环没加到的 res[n - 1]
        sum += res[n - 1] + res.length;
        return sum;
    }

}