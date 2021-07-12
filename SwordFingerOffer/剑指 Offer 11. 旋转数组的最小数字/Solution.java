class Solution {
    public int minArray(int[] numbers) {
        if (numbers[0] < numbers[numbers.length - 1]) return numbers[0];
        int left = 0;
        int right = numbers.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            int midVal = numbers[mid];
            if (midVal > numbers[right]) left = mid;
            else if (midVal < numbers[right]) right = mid;
            else right--;
        }
        return numbers[right];
    }
}