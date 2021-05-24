class Solution {
    public char firstUniqChar(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char key : arr) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (char key : arr) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }
}