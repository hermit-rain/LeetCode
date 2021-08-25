class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1; // res -> 既存储前缀之积同样作为返回数组
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1; //R -> 存后缀之积
        for (int i = n - 1; i >= 0; i--){
            res[i] *= R;
            R *= nums[i];
        }
        return res;
    }

}