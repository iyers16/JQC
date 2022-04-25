package com.example.jqc;

public abstract class GateMatrix {
    private Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(1.00)}
    };

    public GateMatrix(Complex[][] gateMatrix) {
        this.setGateMatrix(gateMatrix);
    }

    public GateMatrix() {}

    public Complex[][] getGateMatrix() {
        return this.GATE_MATRIX;
    }

    public void setGateMatrix(Complex[][] x) {
        this.GATE_MATRIX = x;
    }
}