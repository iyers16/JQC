package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public class Hadamard extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex((1/Math.sqrt(2))), new Complex((1/Math.sqrt(2)))},
        {new Complex((1/Math.sqrt(2))), new Complex(-(1/Math.sqrt(2)))}
    };

    public Hadamard() {
        super("Hadamard", GATE_MATRIX);
    }    
}
