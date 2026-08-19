class Solution {
    public boolean isMatch(String s, String p) {
        int k=s.length();
        int l=p.length();
        boolean dp[][] = new boolean [k+1][l+1];
        dp[k][l]=true;
        for(int j =l-1;j>=0;j--)
        {
            if(j+1<l && p.charAt(j+1)=='*')
            {
                dp[k][j]=dp[k][j+2];
            }else
            {
             dp [k][j]=false;
            }
        }
        for(int i =k-1;i>=0;i--)
        {
            for(int j =l-1;j>=0;j--)
            {
                boolean FirstMatch= (p.charAt(j)==s.charAt(i)|| p.charAt(j)=='.');
                if(j+1<l && p.charAt(j+1)=='*')
                {
                    dp[i][j]=dp[i][j+2]||(FirstMatch && dp[i+1][j]);
                }else{
                    dp[i][j]=FirstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}