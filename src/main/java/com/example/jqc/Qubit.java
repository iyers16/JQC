package com.example.jqc;

import java.util.Scanner;
// import java.lang.Math;

public class Qubit {
    private Complex[][] stateVector;
    private String stateHistory;

    public void userPopulateQubit() {

        Scanner scanner = new Scanner(System.in);

        double[][] userQubit = new double[2][1];

        for(int i = 0; i < userQubit.length; ++i) {
            String mssge = "Please input the " + (i == 0 ? "first" : "second") + "vector-value";
            System.out.print(mssge);
            this.stateVector[i][0] = new Complex(scanner.nextDouble());
        }

        scanner.close();
    }

    public Qubit() {
        this.stateHistory = "";
        this.stateVector = new Complex[2][1];
        this.stateVector[0][0] = new Complex(0.00);
        this.stateVector[1][0] = new Complex(1.00);
        System.out.println("Qubit has been populated by default as |0> ...");
    }

    public Qubit(int state) {
        this.stateHistory = "";
        this.stateVector = new Complex[2][1];

        if(state == 1) {
            this.stateVector[0][0] = new Complex(1.00);
            this.stateVector[1][0] = new Complex(0.00);
            System.out.println("Qubit has been populated as |1> ...");
        } else if(state == 0) {
            this.stateVector[0][0] = new Complex(0.00);
            this.stateVector[1][0] = new Complex(1.00);
            System.out.println("Qubit has been populated as |0> ...");
        }
        else {
            System.out.println("Wrong params!");
            System.exit(1);
        }
    }

    public Complex[][] getState() {
        return this.stateVector;
    }

    public void addGate(PauliX x) {
        this.stateVector = Matrix.multiply(x.getGateMatrix(), this.stateVector);
        this.stateHistory += x.getGateId();
    }
    
    // public void addPauliX() {
        
        // double[][] x = {
        //                 {0, 1},
        //                 {1, 0}
        //                 };
    //     double[][] ans = Matrix.multiply(x, this.stateVector);

    //     this.stateVector = ans;
        
    // }

    // public void addPauliZ() {
        
    //     double[][] y = {
    //                     {1, 0},
    //                     {0, -1}
    //                     };

    //     double[][] ans = Matrix.multiply(y, this.stateVector);

    //     this.stateVector = ans;
        
    // }

    // public void addHadamard() {
        
    //     double[][] h = {
    //                     {(1/Math.sqrt(2)), (1/Math.sqrt(2))},
    //                     {(1/Math.sqrt(2)), -(1/Math.sqrt(2))}
    //                     };

    //     double[][] ans = Matrix.multiply(h, this.stateVector);

    //     this.stateVector = ans;
        
    // }

    public void displayQubit() {
        System.out.println("\nDisplaying state-vector...");
        for(int i = 0; i < 2; ++i) {
            System.out.println("[ " + this.stateVector[i][0] + " ]");
        }
        System.out.println();
    }

}