package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public class Phase extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(0.00, 1.00)}
    };

    public Phase() {
        super("Phase", GATE_MATRIX);
    }
}