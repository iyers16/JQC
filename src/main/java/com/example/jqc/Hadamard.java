package com.example.jqc;

public class Hadamard extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex((1/Math.sqrt(2))), new Complex((1/Math.sqrt(2)))},
        {new Complex((1/Math.sqrt(2))), new Complex(-(1/Math.sqrt(2)))}
    };

    public Hadamard() {
        super("Hadamard", GATE_MATRIX);
        // setGateId("Hadamard");
        // setGateMatrix(GATE_MATRIX);
    }    
}
