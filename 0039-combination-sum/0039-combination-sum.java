class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>>  result = new ArrayList<>();
        backtarck(arr, 0,target,new ArrayList<>(),result);
        return result;
    }
    private void backtarck(int arr[] , int start , int target,List<Integer> list, List<List<Integer>>result )
    {
        if(target<0)
        return ;

        if(target==0)
        {
        result.add(new ArrayList(list));
        
        }
                for(int i =start;i<arr.length;i++)
            {
                list.add(arr[i]);
                backtarck(arr, i,target-arr[i],list,result);
                list.remove(list.size()-1);
            }
        
    }
}