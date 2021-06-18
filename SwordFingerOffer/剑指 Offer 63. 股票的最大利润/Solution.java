class Solution {
    public int maxProfit(int[] prices) {
        int temp = Integer.MAX_VALUE;
        int res = 0;
        for(int price : prices) {
            temp = Math.min(price, temp);
            res = Math.max(res, price - temp);
        }
        return res;
    }
}