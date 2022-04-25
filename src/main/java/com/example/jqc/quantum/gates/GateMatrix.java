package com.example.jqc.quantum.gates;

import com.example.jqc.quantum.Complex;

public abstract class GateMatrix {
    protected Complex[][] GATE_MATRIX = 
    {
        {new Complex(1.00), new Complex(0.00)},
        {new Complex(0.00), new Complex(1.00)}
    };

    public GateMatrix(Complex[][] gateMatrix) {
        this.setGateMatrix(gateMatrix);
    }

    public GateMatrix() {}

    public final Complex[][] getGateMatrix() {
        return this.GATE_MATRIX;
    }

    public final void setGateMatrix(Complex[][] x) {
        this.GATE_MATRIX = x;
    }
}