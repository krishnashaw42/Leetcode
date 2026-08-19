import java.util.*;

class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        result.add(toList(nums));

        for (int i = 1; i < uniqueSteps(nums); i++) {
            nextPermu(nums);
            result.add(toList(nums));
        }

        return result;
    }

    private int uniqueSteps(int[] nums) {

        int total = steps(nums.length);

        List<Integer> freq = uniquestep(nums);

        int div = 1;

        for (int x : freq) {
            if (x > 1) {
                div *= steps(x);
            }
        }

        return total / div;
    }

    private List<Integer> uniquestep(int[] nums) {

        List<Integer> freq = new ArrayList<>();

        int c = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) {
                c++;
            } else {
                freq.add(c);
                c = 1;
            }
        }

        freq.add(c);

        return freq;
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