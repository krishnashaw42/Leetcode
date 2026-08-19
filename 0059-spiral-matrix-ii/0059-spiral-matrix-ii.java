
class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int [n][n];
        int a=1;
        int top = 0;
        int left = 0;
        int bottom = n- 1;
        int right = n- 1;

        while (top <= bottom && left <= right) {

            // left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i]=a;
                a++;
            }
            top++;

            // top to bottom
            for (int j = top; j <= bottom; j++) {
                matrix[j][right]=a;
                a++;
            }
            right--;

            // right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j]=a;
                    a++;
                }
                bottom--;
            }

            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left]=a;
                    a++;
                }
                left++;
            }
        }

        return matrix;
    }
}