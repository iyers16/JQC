package com.example.jqc;
public class Main {
    //Compilation command javac *.java
    //Execution command java Main main.jqc
    public static void main(String[] args) {

        try {
            FileParser parser = new FileParser("/home/iyers16/Programs/JQC/jqc/src/main/java/com/example/jqc/main.jqc");
            FileInterpreter interpreter = new FileInterpreter();
            interpreter.execute(parser.getLineStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // QuantumCircuit qc = new QuantumCircuit(1);
        
        // qc.getQubit(0).displayQubit();

        // Qubit q2 = new Qubit(0);
        // q2.displayQubit();
        // qc.addQubit(q2);
        // q2.addGate(new PauliX());
        // q2.addGate(new PauliX());
        // q2.displayQubit();
        // q2.addGate(new Hadamard());
        // q2.displayQubit();

        // qc.getQubit(0).addGate(new PauliY());
        // qc.getQubit(0).displayQubit();

        // Complex num = new Complex(3, 1);
        // System.out.println(num);
    }
}