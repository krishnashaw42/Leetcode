class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int start, int target,
                           List<Integer> list,
                           List<List<Integer>> result) {

        if (target < 0)
            return;

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            if (i > start && arr[i] == arr[i - 1])
                continue;

            list.add(arr[i]);

            backtrack(arr, i + 1, target - arr[i], list, result);

            list.remove(list.size() - 1);
        }
    }
}