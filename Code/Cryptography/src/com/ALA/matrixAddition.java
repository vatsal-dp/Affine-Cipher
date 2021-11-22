package com.ALA;

import java.util.Arrays;

public class matrixAddition {
    //this method is used for matrix addition during encryption
    static int[][] add(int[][] matrix1, int[][] matrix2) {

        int[][] additionMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                additionMatrix[i][j] = matrix2[i][j] + matrix1[i][j];

                additionMatrix[i][j] %= 29;
            }
        }
        return additionMatrix;
    }

}
