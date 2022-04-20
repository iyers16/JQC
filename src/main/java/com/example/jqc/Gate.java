package com.example.jqc;

import com.example.jqc.interfaces.IGateInfo;

public class Gate extends GateMatrix implements IGateInfo {

    private String gateId;
    
    @Override
    public String toString() {
        return(
            "Gate Information:"
            + "\n\n"
            + "---------------------------------------------"
            + "Gate name: " + this.gateId
            + "Gate matrix: " + this.getGateMatrix()
            + "---------------------------------------------"
        );
    }

    @Override
    public String getGateId() {
        return this.gateId;
    }

    @Override
    public void setGateId(String x) {
        this.gateId = x;
    }
}
