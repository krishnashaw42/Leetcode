class Solution {
    public int jump(int[] nums) {
        int pos = 0;
        int jumps = 0;

        while (pos < nums.length - 1) {
            if (pos + nums[pos] >= nums.length - 1) {
                jumps++;
                break;
            }

            int best = pos + 1;

            for (int i = pos + 1; i <= pos + nums[pos]; i++) {
                if (i + nums[i] > best + nums[best]) {
                    best = i;
                }
            }

            pos = best;
            jumps++;
        }

        return jumps;
    }
}