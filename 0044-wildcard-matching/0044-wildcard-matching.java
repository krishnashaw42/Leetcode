import java.util.Stack;

class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;

        Stack<int[]> stack = new Stack<>();

        while (i < s.length()) {

            if (j < p.length() &&
                (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            else if (j < p.length() && p.charAt(j) == '*') {
                stack.push(new int[]{i, j});
                j++;
            }

            else if (!stack.isEmpty()) {
                int[] last = stack.peek();

                i = last[0] + 1;   // '*' matches one more character
                j = last[1] + 1;

                last[0] = i;
            }

            else {
                return false;
            }
        }

        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }
}