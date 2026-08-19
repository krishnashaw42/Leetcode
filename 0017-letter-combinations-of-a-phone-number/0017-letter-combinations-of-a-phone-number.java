import java.util.ArrayList;
import java.util.List;

class Solution {
    // Keypad mapping where index matches the digit value
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: if input is empty
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start the backtracking process from index 0
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if the current combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digitChar = digits.charAt(index);
        String letters = KEYPAD[digitChar - '0'];

        // Explore all potential paths
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            
            current.append(letter);  // Choose
            backtrack(digits, index + 1, current, result); // Explore
            current.deleteCharAt(current.length() - 1);  // Un-choose (Backtrack)
        }
    }
}