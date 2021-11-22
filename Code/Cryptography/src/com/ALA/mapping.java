package com.ALA;

import java.util.Arrays;

public class mapping {
    //these two methods are used to characters to integer values and
    //convert integer values to corresponding characters
    //it also contains our modification of special characters
    static int[][] number(char[][] matrix) {
        int[][] convertedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==' '){
                    convertedMatrix[i][j] = 26;
                }
                else if(matrix[i][j] == '?'){
                    convertedMatrix[i][j] = 27;
                }
                else if(matrix[i][j] == '.'){
                    convertedMatrix[i][j] = 28;
                }
                else{
                    convertedMatrix[i][j] = (int) (matrix[i][j]) - 'A';
                }
            }
        }
        return convertedMatrix;
    }

    static char[][] alphabet(int[][] matrix) {
        char[][] convertedMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==26) {
                    convertedMatrix[i][j] = ' ';
                }
                else if(matrix[i][j]==27) {
                    convertedMatrix[i][j] = '?';
                }
                else if(matrix[i][j]==28) {
                    convertedMatrix[i][j] = '.';
                }
                else
                {
                    convertedMatrix[i][j] = (char) (matrix[i][j] + 'A');
                }
            }
        }
        return convertedMatrix;
    }

}
