package com.example.jqc.quantum.gates;

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
        return(
            "Gate Information:"
            + "\n\n---------------------------------------------\n"
            + "Gate name: " + this.gateId
            + "Gate matrix: " + this.getGateMatrix()
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
