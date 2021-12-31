package com.ALA;

public class matrixInversion {

    static int A[][];
    static int N;

    matrixInversion(int[][] m) {
        A = m;
        N = A.length;
    }
    //cofactor method is used to calculate cofactors of all elements of matrices
    //this is then used in finding the adjoint of matrix
    static void getCofactor(int A[][], int temp[][], int p, int q, int n) {
        int i = 0, j = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                if (row != p && col != q) {
                    temp[i][j++] = A[row][col];

                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
    //determinant is calculated to facilitate the inversion process and
    //even check the invertibility of a matrix
    static int determinant(int A[][], int n) {
        int D = 0;

        if (n == 1)
            return A[0][0];

        int[][] temp = new int[N][N];

        int sign = 1;

        for (int f = 0; f < n; f++) {

            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1);

            sign = -sign;
        }

        return D;
    }

    static void adjoint(int A[][], int[][] adj) {
        if (N == 1) {
            adj[0][0] = 1;
            return;
        }

        int sign = 1;
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                getCofactor(A, temp, i, j, N);

                sign = ((i + j) % 2 == 0) ? 1 : -1;

                adj[j][i] = (sign) * (determinant(temp, N - 1));
            }
        }
    }
    //this method is ud=sed to find modular multiplicative inverse
    static int modInverse(int a, int m)
    {
        for (int x = 1; x < m; x++)
            if (((a%m) * (x%m)) % m == 1)
                return x;
        return 1;
    }
    //matrix inverse is calculated in this method
    // Driver program
    public static int[][] main() {

        int detA = determinant(A,A.length);

        while(detA<0){
            detA += 97;
        }

        if(detA==0){
            System.out.println("Matrix is not invertible.");
            System.exit(1);
        }

        detA = modInverse(detA,97);
        int[][] adj = new int[N][N]; // To store adjoint of A[][]


        adjoint(A, adj);

        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                adj[i][j]*=detA;
                while(adj[i][j]<0){
                    adj[i][j]+=97;
                }
            }
        }
        return adj;
    }
}


