class Solution {
    public int search(int[] nums, int target)
    {
        int i;
        int n=nums.length;
        boolean flag=false;
        for(i =0;i<n;i++)
        {
            if(nums[i]==target)
            {
                flag=true;
                break;

            }
            else 
            continue;

        }
        if(flag)
        return i;
        else 
        return -1;
    }
}