package com.example.jqc;

public class Phase extends Gate {
    private static final Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(0.00, 1.00)}
    };

    public Phase() {
        setGateId("Phase");
        setGateMatrix(GATE_MATRIX);
    }
}