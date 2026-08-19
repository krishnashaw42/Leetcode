import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;


        List<List<Integer>> result = new ArrayList<>();

        result.add(toList(nums));

        for (int i = 1; i < steps(n); i++) {
            nextPermu(nums);
            result.add(toList(nums));
        }

        return result;
    }

    private int steps(int n) {
        int f = 1;

        for (int i = 1; i <= n; i++) {
            f *= i;
        }

        return f;
    }

    private void nextPermu(int[] nums) {

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

    private List<Integer> toList(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }

        return list;
    }
}