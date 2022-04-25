package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public class PauliY extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(0.00), new Complex(0.00, -1.00)},
        {new Complex(0.00, 1.00), new Complex(0.00)}
    };

    public PauliY() {
        super("Pauli-Y", GATE_MATRIX);
    }
}