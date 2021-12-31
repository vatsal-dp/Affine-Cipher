package com.ALA;

public class matrixMultiplication {
    //matrix multiplication method is used in multiple stages of encryption and decryption
    static int[][] multiply(int[][] A, int[][] P) {
        int[][] C = new int[A.length][P[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < P[0].length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < P.length; k++) {
                    C[i][j] += A[i][k] * P[k][j];
                    C[i][j] %= 97;
                }
            }
        }
        return C;

    }

}
