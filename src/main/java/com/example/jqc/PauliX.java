package com.example.jqc;

public class PauliX extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(0.00), new Complex(1.00)},
        {new Complex(1.00), new Complex(0.00)}
    };

    public PauliX() {
        setGateId("Pauli-X");
        setGateMatrix(GATE_MATRIX);
    }
}