class Solution {
    public int lengthOfLongestSubstring(String s) {
        String w = "";
        int max = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            
            if (w.contains(ch)) {
                int x = w.indexOf(ch);
                w = w.substring(x + 1);
            }
            w = w + ch;   
            if (w.length() > max) {
                max = w.length();
            }
        }       
        return max;
    }
}
