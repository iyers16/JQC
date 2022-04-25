package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public class PauliZ extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(-1.00)}
    };

    public PauliZ() {
        super("Pauli-Z", GATE_MATRIX);
    }
}