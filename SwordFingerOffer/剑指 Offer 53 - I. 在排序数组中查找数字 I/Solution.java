class Solution {
    public int search(int[] nums, int target) {
        int midIndex = binarySearch(nums, 0, nums.length - 1, target);
        //midIndex == -1 ==> 没有找到则返回 0
        if (midIndex == -1) {
            return 0;
        }
        //定义count用于记录 target 的次数，起始值为 1 => 因为分别向左向右扫描 midIndex 本身算一次
        int count = 1;
        //向左扫描
        int temp = midIndex - 1;
        while (true) {
            //先判断 temp 的范围再判断数值 否则报数组下标异常
            if (temp < 0 || nums[temp] != target) {
                break;
            }
            count++;
            temp--;
        }
        //向右扫描
        temp = midIndex + 1;
        while (true) {
            if (temp > nums.length - 1 || nums[temp] != target) {
                break;
            }
            count++;
            temp++;
        }
        return count;
    }

    /**
     * 二分查找数组中的元素
     *
     * @param arr 待查找数组
     * @param left 左索引
     * @param right 右索引
     * @param findVal 输入待查找元素
     * @return 找到则返回目标元素下标，否则返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}