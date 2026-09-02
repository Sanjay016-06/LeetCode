class NumMatrix {
    int[][] matrix;

    int[][] pmSum;
    public void getMatrixPrefixSum(int[][] matrix) {
        pmSum[0][0] = matrix[0][0];
        for (int col = 1; col < matrix[0].length; col++) {
            pmSum[0][col] = pmSum[0][col - 1] + matrix[0][col];
        }
        for (int row = 1; row < matrix.length; row++) {
            pmSum[row][0] = pmSum[row - 1][0] + matrix[row][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                pmSum[i][j] =
                        pmSum[i - 1][j]
                      + pmSum[i][j - 1]
                      - pmSum[i - 1][j - 1]
                      + matrix[i][j];
            }
        }
    }
    public int getValue(int row, int col) {

        if (row < 0 || col < 0)
            return 0;

        return pmSum[row][col];
    }

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;

        pmSum = new int[matrix.length][matrix[0].length];

        getMatrixPrefixSum(matrix);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = getValue(row2, col2);
        int top = getValue(row1 - 1, col2);
        int left = getValue(row2, col1 - 1);
        int overlap = getValue(row1 - 1, col1 - 1);

        return total - top - left + overlap;
    }
}