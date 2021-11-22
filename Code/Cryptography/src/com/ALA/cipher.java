//MAIN

package com.ALA;

import java.util.*;

public class cipher {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //We take the message as input.
        System.out.print("Enter message to be encrypted: ");
        String inputText = sc.nextLine();

        System.out.print("Enter number of key matrices: ");
        int keys = sc.nextInt();

        //Number of key matrices are taken and accordingly random keys with fixed size are inputted
        System.out.print("Enter size of square key matrix: ");
        int n = sc.nextInt();

        //the decision (of how many characters to encrypt at a time) is taken in the below function
        if(inputText.length()%n != 0){
            int diff = (n*((int)(inputText.length()/n)+1))-(inputText.length());
            for(int i = 0;i<diff;i++){
                inputText += " ";
            }
        }

        int[][] multipliedMatrix = new int[n][n];

        for (int i = 0; i < keys; i++) {
            System.out.println("Enter elements of key matrix " + (i + 1) + " : ");

            int[][] A = new int[n][n];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    A[j][k] = sc.nextInt();
                }
            }
            //ENCRYPTION
            //here we calculate the multiplication of all key matrices that were given as an input
            if (i == 0) {
                multipliedMatrix = A;
            } else {
                multipliedMatrix = matrixMultiplication.multiply(multipliedMatrix, A);
            }
        }

        //the matrix for addition is taken as input
        System.out.print("Enter key matrix of size [" + n + "x1] for addition: ");
        int[][] B = new int[n][1];
        for (int i = 0; i < n; i++) {
            B[i][0] = sc.nextInt();
        }

        String encryptedText = "";

        //inverse of the multiplied matrix is generated here
        char[][] inputArray = new char[n][1];
        matrixInversion temp = new matrixInversion(multipliedMatrix);
        int[][] inverseMatrix = temp.main();
        char[][] encryptedMatrix;

        //the string input is converted to matrix form by mapping to integer values
        for (int i = 0; i < inputText.length(); i = i + n) {
            int idx = 0;
            for (int j = i; j < i + n; j++) {
                inputArray[idx++][0] = inputText.charAt(j);
            }

            int[][] P = mapping.number(inputArray);

            //the encrypted matrix is multiplied to the multiplied matrix and
            // added to addition matrix. This generates the cipher matrix that
            // is obtained as the result of encryption
            P = matrixMultiplication.multiply(multipliedMatrix, P);
            P = matrixAddition.add(P, B);
            P = AlphabetCheck.modulus(P);

            //the cipher matrix is mapped to corresponding characters to generate the encrypted text
            encryptedMatrix = mapping.alphabet(P);

            for (int j = 0; j < encryptedMatrix.length; j++) {
                encryptedText += encryptedMatrix[j][0];
            }
        }

        System.out.print("Encrypted text: ");
        System.out.println(encryptedText);

        //DECRYPTION
        char[][] outputArray = new char[n][1];
        char[][] decryptedMatrix;
        String decryptedText = "";

        //here the encrypted text is converted to output array while taking modulus 29
        for (int i = 0; i < encryptedText.length(); i = i + n) {

            int idx = 0;
            for (int j = i; j < i + n; j++) {
                outputArray[idx++][0] = encryptedText.charAt(j);
            }
            //the inverse matrix is multiplied to the subtraction of
            // encryption matrix and addition matrix

            int[][] P2 = mapping.number(outputArray);
            P2 = matrixSubtraction.subtract(B, P2);
            int[][] P3 = matrixMultiplication.multiply(inverseMatrix, P2);

            P3 = AlphabetCheck.modulus(P3);

            //the decryption matrix thus obtained is mapped again to the characters
            //this conversion retrieves the original text message
            decryptedMatrix = mapping.alphabet(P3);

            for (int j = 0; j < decryptedMatrix.length; j++) {
                decryptedText += decryptedMatrix[j][0];
            }
        }

        System.out.print("Decrypted message: ");
        System.out.println(decryptedText);

    }

}
