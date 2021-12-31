package com.ALA;

import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class mapping {
    //these two methods are used to characters to integer values and
    //convert integer values to corresponding characters
    //it also contains our modification of special characters
    static int[][] number(char[][] matrix) {
        int[][] convertedMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==' ') {
                    convertedMatrix[i][j] = 94;
                }
                else if(matrix[i][j]=='µ') {
                    convertedMatrix[i][j] = 95;
                }
                else if(matrix[i][j]=='÷') {
                    convertedMatrix[i][j] = 96;
                }
                else
                    convertedMatrix[i][j] = (int) (matrix[i][j]) - '!';
            }
        }
        return convertedMatrix;
    }

    static char[][] alphabet(int[][] matrix) {
        char[][] convertedMatrix = new char[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==94) {
                    convertedMatrix[i][j] = ' ';
                }
                else if(matrix[i][j]==95) {
                    convertedMatrix[i][j] = 'µ';
                }
                else if(matrix[i][j]==96) {
                    convertedMatrix[i][j] = '÷';
                }
                else
                    convertedMatrix[i][j] = (char) (matrix[i][j] + '!');
            }
        }
        return convertedMatrix;
    }

}
