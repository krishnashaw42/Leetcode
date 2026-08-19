import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String p : parts) {

            if (p.equals("") || p.equals(".")) {
                continue;
            }

            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(p);
            }
        }

        StringBuilder ans = new StringBuilder();

        for (String dir : stack) {
            ans.append("/").append(dir);
        }

        return ans.length() == 0 ? "/" : ans.toString();
    }
}