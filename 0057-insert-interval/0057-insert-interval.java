class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        int[][] arr1 = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            arr1[i][0] = intervals[i][0];
            arr1[i][1] = intervals[i][1];
        }

        arr1[n][0] = newInterval[0];
        arr1[n][1] = newInterval[1];

        return merge(arr1);
    }

    private int[][] merge(int[][] intervals) {
        int n = intervals.length;

        if (n <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        LinkedList<int[]> result = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            while (j < n && end >= intervals[j][0]) {
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            result.add(new int[]{start, end});
            i = j - 1;
        }

        return result.toArray(new int[result.size()][]);
    }
}