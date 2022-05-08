package com.example.jqc.quantum.gates;

import java.util.Arrays;

import com.example.jqc.interfaces.GateInfoInterface;
import com.example.jqc.quantum.Complex;

public class Gate extends GateMatrix implements GateInfoInterface {
    private String gateId;

    public Gate() {
        super();
    }
    public Gate(String id, Complex[][] gateMatrix) {
        super(gateMatrix);
        this.gateId = id;
    }

    @Override
    public final String toString() {
        String matrixSet = "[";
        for (Complex[] row : this.getGateMatrix()) {
            matrixSet += Arrays.toString(row) + ",\n";
        }
        matrixSet = matrixSet.substring(0, matrixSet.length() - 1);
        matrixSet += "]";

        return(
            "Gate Information:"
            + "\n\n---------------------------------------------\n"
            + "\nGate name: " + this.gateId
            + "\nGate matrix: \n" + matrixSet
            + "\n---------------------------------------------\n"
        );
    }

    public final String getGateId() {
        return this.gateId;
    }

    public final void setGateId(String x) {
        this.gateId = x;
    }
}
