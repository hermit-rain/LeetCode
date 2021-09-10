class Solution {
    public static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 == 1) return false;
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        for (int i = 0; i < len; i++) {
            char temp = s.charAt(i);
            if (map.containsKey(temp)) {
                if (!stack.isEmpty() && stack.peek() == map.get(temp)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(temp);
            }
        }
        return stack.isEmpty();
    }
}