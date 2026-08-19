import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        // First pointer loop
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Second pointer loop (The missing loop from your code!)
            for (int j = i + 1; j < n - 2; j++) {
              
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

               
                int p1 = j + 1;
                int p2 = n - 1;

                while (p1 < p2) {
                    
                    long sum = (long) nums[i] + nums[j] + nums[p1] + nums[p2];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[p1], nums[p2]));

                        // Skip duplicates for p1 and p2 to avoid processing identical pairs
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;

                        p1++;
                        p2--;
                    } else if (sum < target) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }
        return result;
    }
}