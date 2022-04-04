package com.example.jqc;

public class Main {
    public static void main(String[] args) {
        QuantumCircuit qc = new QuantumCircuit(1);
        
        qc.getQubit(0).displayQubit();

        Qubit q2 = new Qubit(0);
        q2.displayQubit();
        qc.addQubit(q2);

        // qc.getQubit(1).addPauliX();
        // qc.getQubit(1).displayQubit();

        // qc.getQubit(1).addHadamard();
        // qc.getQubit(1).displayQubit();

        // qc.getQubit(0).addPauliX();
        // qc.getQubit(0).displayQubit();
        
        // qc.getQubit(0).addPauliX();
        // qc.getQubit(0).displayQubit();

        // qc.getQubit(0).addHadamard();
        // qc.getQubit(0).displayQubit();

        // qc.getQubit(0).addHadamard();
        // qc.getQubit(0).displayQubit();

        Complex num = new Complex(3, 1);
        System.out.println(num);
        
    }
}