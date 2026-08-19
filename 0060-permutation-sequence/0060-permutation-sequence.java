class Solution {
    public String getPermutation(int n, int k) 
    { int arr[] = new int [n];
    String s="";
        for(int i =0;i<n;i++)
        {
          arr[i]=i+1;
        }
        for(int i =1;i<k;i++)
        {
            arr=nextPermu(arr);
        }
        for(int i =0;i<n;i++)
        {
            s=s+arr[i];
        }
        return s;
    }
        private int [] nextPermu(int[] nums) {

        int n = nums.length;

        int i = n - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = n - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
        return nums;
    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}