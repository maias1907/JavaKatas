package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class rotateMatrixTest {
    @Test
    public void testrotateMatrix(){
        // Test 1  Basic 3x3 matrix
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected1 = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        MatrixRotate.rotateMatrix(matrix1);
        assertArrayEquals(expected1, matrix1, "The 3x3 matrix should be rotated 90 degrees clockwise.");

        // Test 2 4x4 matrix
        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] expected2 = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        MatrixRotate.rotateMatrix(matrix2);
        assertArrayEquals(expected2, matrix2, "The 4x4 matrix should be rotated 90 degrees clockwise.");

        // Test 3 Empty matrix
        int[][] matrix3 = {};
        int[][] expected3 = {};
        MatrixRotate.rotateMatrix(matrix3);
        assertArrayEquals(expected3, matrix3, "An empty matrix should remain empty after rotation.");

        // Test 4 Single element matrix
        int[][] matrix4 = {
                {5}
        };
        int[][] expected4 = {
                {5}
        };
        MatrixRotate.rotateMatrix(matrix4);
        assertArrayEquals(expected4, matrix4, "A single-element matrix should remain unchanged after rotation.");

        // Test 5  2x2 matrix
        int[][] matrix5 = {
                {1, 2},
                {3, 4}
        };
        int[][] expected5 = {
                {3, 1},
                {4, 2}
        };
        MatrixRotate.rotateMatrix(matrix5);
        assertArrayEquals(expected5, matrix5, "The 2x2 matrix should be rotated 90 degrees clockwise.");


    }
}
