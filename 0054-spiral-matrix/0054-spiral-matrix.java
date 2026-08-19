class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> result = new ArrayList<>();
        int top=0;
        int left=0;
        int bottom= matrix.length - 1;
        int right= matrix[0].length - 1;
        while (top <= bottom && left <= right) {
        //from left to right 
        for(int i =left;i<=right;i++)
        {
            result.add(matrix[top][i]);
        }
        top++;
        //from top to bottom 
        for(int j =top;j<=bottom;j++)
        {
            result.add(matrix[j][right]);
        }
        right--;
        //from right to left
        if (top <= bottom) {
        for(int j =right;j>=left;j--)
        {
            result.add(matrix[bottom][j]);
        }
        bottom--;
        }
        //from bottom to top
        if (left <= right) {
        for(int i =bottom;i>=top;i--)
        {
            result.add(matrix[i][left]);
        }
        left++;
        }
        }
         return result;
    }
}