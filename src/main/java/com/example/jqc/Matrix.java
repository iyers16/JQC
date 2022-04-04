package com.example.jqc;

// import java.lang.Math;

public class Matrix {
    static Complex[][] multiply(Complex[][] A, Complex[][] B) {
        
        int numOfRowsA = A.length;
        int numOfColumnsA = A[0].length;
        int numOfRowsB = B.length;
        int numOfColumnsB = B[0].length;

        Complex[][] ret = new Complex[numOfRowsA][numOfColumnsB];

        if (numOfRowsB != numOfColumnsA) {
            System.out.println("\nMultiplication Not Possible");
            return null;
        }

        // The product matrix will be of size numOfRowsA x numOfColumnsB
        for (int i = 0; i < numOfRowsA; i++) {
            for (int j = 0; j < numOfColumnsB; j++) {
                for (int k = 0; k < numOfRowsB; k++) {
                    ret[i][j] = A[i][k]
                                .multiply(B[k][j])
                                .add(ret[i][j]);
                }
            }
        }

        return ret;
    }
}