package com.example.jqc.quantum;

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

    public final void addQubit() {
        Qubits.add(new Qubit());
    }

    public final void addQubit(Qubit qubit) {
        Qubits.add(qubit);
    }
    
    public final ArrayList<Qubit> getQubits() {
        return this.Qubits;
    }

    public final Qubit getQubit(int indexOfQubit) {
        return this.Qubits.get(indexOfQubit);
    }
}