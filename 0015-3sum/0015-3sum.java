class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null || nums.length<3)
        return new ArrayList<>();
        Arrays.sort(nums);
        Set<List<Integer>>result = new HashSet<>();
        for( int i =0;i<nums.length-2;i++)
        {
            int p1=i+1;
            int p2=nums.length-1;
            while(p1<p2)
            {
                int sum=nums[i]+nums[p1]+nums[p2];
                if(sum==0){
                result.add(Arrays.asList(nums[i],nums[p1],nums[p2]));
                p1++;
                p2--;
                }else if(sum<0) {
                    p1++;

                }
                else {
                    p2--;
                }
            }}
            return new ArrayList<>(result);
        
    }
}