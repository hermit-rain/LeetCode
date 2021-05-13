class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;  //定义左右上下四个边界
        int[] res = new int[(r + 1) * (b + 1)]; //定义返回值数组用于接收矩阵中的元素
        int index = 0;  //res->索引下标
        while (true) {
            for (int i = l; i <= r; i++) {  //从左向右遍历
                res[index] = matrix[t][i];  //t->沿着上边界走行不变
                index++;
            }
            if (++t > b) break;
            for (int i = t; i <= b; i++) {  //从上向下遍历
                res[index] = matrix[i][r];  //r -> 沿着右边界走列不变
                index++;
            }
            if (l > --r) break;
            for (int i = r; i >= l; i--) {  //从右向左遍历
                res[index] = matrix[b][i];  //b -> 沿着下边界走行不变
                index++;
            }
            if (t > --b) break;
            for (int i = b; i >= t; i--) {  //从下向上遍历
                res[index] = matrix[i][l];  //l -> 沿着左边界走列不变
                index++;
            }
            if (++l > r) break;
        }
        return res;
    }
}