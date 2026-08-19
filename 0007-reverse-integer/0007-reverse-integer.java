class Solution {
    public int reverse(int x) {
        int rev = 0;
        
        while (x != 0) {
            int p = x % 10;
            x = x / 10;
            
            int temp = rev * 10 + p;
            
            if ((temp - p) / 10 != rev) {
                return 0;
            }
            
            rev = temp;
        }
        
        return rev;
    }
}