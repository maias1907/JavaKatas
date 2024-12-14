package katas.exercises;

public class MatrixRotate {

    /**
     * Rotates the given square matrix 90 degrees clockwise in place.
     *
     * @param matrix the 2D square matrix to rotate
     */
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;

        // Iterate through each layer
        for (int i = 0; i < n / 2; i++) {

            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("Matrix after 90-degree clockwise rotation:");
        printMatrix(matrix);
    }

    /**
     * Helper method to print a 2D matrix.
     *
     * @param matrix the matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
