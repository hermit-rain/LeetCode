class Solution {
    public String minNumber(int[] nums) {
        bubbleSort(nums);
        return Arrays.toString(nums).replaceAll("\\[|]|,|\\s", "");
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (("" + arr[j] + arr[j + 1]).compareTo("" + arr[j + 1] + arr[j]) > 0) {
                    flag = true;
                    arr[j + 1] = arr[j] + arr[j + 1];
                    arr[j] = arr[j + 1] - arr[j];
                    arr[j + 1] = arr[j + 1] - arr[j];
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}