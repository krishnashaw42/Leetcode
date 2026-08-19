class Solution {
    public String longestPalindrome(String s) {   
      if (s == null || s.length() < 1) return "";
        
        int st = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int a1 = i;
            int b1 = i;
            while (a1 >= 0 && b1 < s.length() && s.charAt(a1) == s.charAt(b1)) {
                int len = b1 -a1 + 1;
                if (len > max) {
                    st = a1;
                    max = len;
                }
                a1--;
                b1++;
            }
            
            int a2 = i;
            int b2 = i + 1;
            while (a2 >= 0 && b2 < s.length() && s.charAt(a2) == s.charAt(b2)) {
                int len = b2 - a2 + 1;
                if (len > max) {
                    st = a2;
                    max = len;
                }
                a2--;
                b2++;
            }
        }
        
        return s.substring(st, st + max);
    }
}