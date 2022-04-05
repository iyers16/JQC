package com.example.jqc;

public class Main {
    public static void main(String[] args) {
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