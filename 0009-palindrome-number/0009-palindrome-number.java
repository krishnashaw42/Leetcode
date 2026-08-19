class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int l=x;
        if(x<0)
        return false;
        while (l != 0) {
            int p = l % 10;
            l= l / 10;
            
            int temp = rev * 10 + p;
            
            rev = temp;
        }
        if(x==rev)
        return true;
        else 
        return false;
    }
}