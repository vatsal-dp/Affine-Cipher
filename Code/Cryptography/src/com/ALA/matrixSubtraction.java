package com.ALA;

public class matrixSubtraction {
    //matrix subtraction is used during the decryption phase when addition matrix is subtracted

    static int[][] subtract(int[][] matrix1, int[][] matrix2) {

        int[][] subtractionMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                subtractionMatrix[i][j] = matrix2[i][j] - matrix1[i][j];
                subtractionMatrix[i][j] %= 29;
            }
        }
        return subtractionMatrix;
    }
}
