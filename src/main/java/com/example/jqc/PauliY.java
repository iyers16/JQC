package com.example.jqc;

public class PauliY extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(0.00), new Complex(0.00, -1.00)},
        {new Complex(0.00, 1.00), new Complex(0.00)}
    };

    public PauliY() {
        setGateId("Pauli-Y");
        setGateMatrix(GATE_MATRIX);
    }
}