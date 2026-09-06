class Solution {
    public void rotate(int[][] matrix) {

        // Step 1: Transpose the matrix
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int row = 0; row < N; row++) {

            int startcol = 0;
            int endcol = N - 1;

            while (startcol < endcol) {

                int temp = matrix[row][startcol];
                matrix[row][startcol] = matrix[row][endcol];
                matrix[row][endcol] = temp;

                startcol++;
                endcol--;
            }
        }
    }
}