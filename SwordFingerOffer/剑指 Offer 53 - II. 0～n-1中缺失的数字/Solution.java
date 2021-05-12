class Solution {
    public int missingNumber(int[] nums) {
        int l = 0; //左指针
        int r = nums.length - 1; //右指针
        //l > r => 循环退出的条件
        while (l <= r) {
            int mid = (l + r) / 2;
            // mid == nums[mid] => 丢失的数字在 mid 右侧 -> 左指针右移
            if (mid == nums[mid]) {
                l = mid + 1;
            } else { //mid != nums[mid] => 丢失的数字在 mid 左侧 -> 右指针左移
                r = mid - 1;
            }
        }
        //循环跳出后 此时 l索引 即为丢失的数字
        return l;
    }
}