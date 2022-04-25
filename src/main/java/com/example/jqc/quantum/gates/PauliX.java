package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public class PauliX extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(0.00), new Complex(1.00)},
        {new Complex(1.00), new Complex(0.00)}
    };

    public PauliX() {
        super("Pauli-X", GATE_MATRIX);
    }
}