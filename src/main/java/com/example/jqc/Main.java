package com.example.jqc;

import java.io.File;

public class Main {
    //Compilation command javac *.java
    //Execution command java Main.java main.jqc
    public static void main(String[] args) {

        try {
            String filename = args[0];
            File file = new File(filename);
            String absolutePath = file.getAbsolutePath();
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        

        QuantumCircuit qc = new QuantumCircuit(1);
        
        qc.getQubit(0).displayQubit();

        Qubit q2 = new Qubit(0);
        q2.displayQubit();
        qc.addQubit(q2);
        q2.addGate(new PauliX());
        q2.addGate(new PauliX());
        q2.displayQubit();
        q2.addGate(new Hadamard());
        q2.displayQubit();

        qc.getQubit(0).addGate(new PauliY());
        qc.getQubit(0).displayQubit();

        Complex num = new Complex(3, 1);
        System.out.println(num);
        
    }
}