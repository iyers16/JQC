package com.example.jqc;

public interface IGateMatrix {
    public static Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(1.00)}
    };

    public Complex[][] getGateMatrix();

    @Override
    public String toString();
}
