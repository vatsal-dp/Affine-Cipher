package com.ALA;

public class AlphabetCheck {
    //here the numerical values in matrices that are greater than 97
    //are converted to lesser values by taking mod with 97
    static int[][] modulus(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                while (matrix[i][j] < 0) matrix[i][j] += 97;
                matrix[i][j] %= 97;
            }
        }
        return matrix;
    }

}
