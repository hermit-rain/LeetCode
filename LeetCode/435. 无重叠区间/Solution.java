class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        //对二维数组按照起始元素进行排序
        Arrays.sort(intervals, (o1, o2) -> (o1[0] - o2[0]));
        int res = 0; //需要消除的区间数量 -> 初始值为0
        int end = intervals[0][1];  //定义右边界 -> 初始化为 intervals[0][1]
        for (int i = 1; i < intervals.length; i++) {
            if (end <= intervals[i][0]) { //当当前区间的右边界小于下一个区间的左边界时,顺延更新右边界并继续遍历
                end = intervals[i][1];
            } else { //当当前区间的右边界大于下一个区间的左边界时,消除带有较大右边界的区间
                end = Math.min(end, intervals[i][1]);
                res++;
            }
        }
        return res;
    }
}