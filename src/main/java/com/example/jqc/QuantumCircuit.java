package com.example.jqc;

import java.util.ArrayList;

public class QuantumCircuit extends ArrayList<Qubit> {
    private ArrayList<Qubit> Qubits;

    public QuantumCircuit(int numberOfQubits) {
        Qubits = new ArrayList<Qubit>();
        for (int i = 0; i < numberOfQubits; ++i) {
            Qubits.add(new Qubit());
        }
    }

    public QuantumCircuit(ArrayList<Qubit> qubits) {
        Qubits = qubits;
    }

    public QuantumCircuit() {
        Qubits = new ArrayList<Qubit>();
    }

    public void addQubit() {
        Qubits.add(new Qubit());
    }

    public void addQubit(Qubit qubit) {
        Qubits.add(qubit);
    }
    
    public ArrayList<Qubit> getQubits() {
        return this.Qubits;
    }

    public Qubit getQubit(int indexOfQubit) {
        return this.Qubits.get(indexOfQubit);
    }
}