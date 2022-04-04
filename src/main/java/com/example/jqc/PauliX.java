package com.example.jqc;

public class PauliX extends Gate implements IGateMatrix {
    private final Complex[][] GATE_MATRIX = 
    {
        {new Complex(0.00), new Complex(1.00)},
        {new Complex(1.00), new Complex(0.00)}
    };

    private static final String gateID = "Pauli-X";

    public Complex[][] getGateMatrix() {
        return this.GATE_MATRIX;
    }   

}
