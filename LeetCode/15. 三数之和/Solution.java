class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); //先将数组进行排序
        List<List<Integer>> res = new ArrayList<>(); //定义接收集合
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) { //越过重复的元素
                continue;
            }
            int third = n - 1; //定义右指针
            int target = -nums[first]; //模拟两数之和
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]){  //越过重复的元素
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    //将找到了和为零的三个数字存放进入 list 集合中
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}