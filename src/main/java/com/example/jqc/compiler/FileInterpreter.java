package com.example.jqc.compiler;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.example.jqc.interfaces.FileInterpreterInterface;
import com.example.jqc.quantum.QuantumCircuit;
import com.example.jqc.quantum.Qubit;
import com.example.jqc.quantum.gates.Gate;
import com.example.jqc.quantum.gates.Hadamard;
import com.example.jqc.quantum.gates.PauliX;
import com.example.jqc.quantum.gates.PauliY;
import com.example.jqc.quantum.gates.PauliZ;
import com.example.jqc.quantum.gates.Phase;

public class FileInterpreter implements FileInterpreterInterface {
    private HashMap<String, QuantumCircuit> circuitMap;
    private HashMap<String, Qubit> qubitMap;
    private HashMap<String, Gate> gateMap;
    

    public FileInterpreter() {
        this.circuitMap = new HashMap<String, QuantumCircuit>();
        this.qubitMap = new HashMap<String, Qubit>();
        this.gateMap = new HashMap<String, Gate>();
    }

    public final void execute(ArrayList<Line<String>> lines) {
        for(Line<String> line : lines) {
            this.parseAction(
                line.getInstructionTree().getActionToken().getData(), 
                line
            );
        }
    }

    public final void parseAction(String a, Line<String> line) {
        switch (a) {
            case "add":
                this.parseAdd(line);
                break;
            case "display":
                this.parseDisplay(line);
                break;
            case "terminate":
                FileInterpreter.terminateAllProcesses();
                break;
            default:
                System.out.println("Invalid action token!");
                break;
        }
    }

    public final void parseDisplay(Line<String> line) {
        String type = line.getInstructionTree().getTypeToken().getData();
        String target = line.getInstructionTree().getTargetToken().getData();
        String origin = line.getInstructionTree().getOriginToken().getData();
        switch (target) {
            case "cli":
                this.displayToCLI(type, origin);
                break;
            case "file":
                this.displayToFile(type, origin, target);
                break;
            default:
                System.out.println("Invalid target token!");
                break;

        }
	}

	public final void displayToCLI(String type, String origin) {
        switch (type) {
            case "statevector":
                this.displayStateVector(origin);
                break;
            case "qubit":
                this.displayQubit(origin);
                break;
            case "gate":
                this.displayGate(origin);
                break;
            default:
                System.out.println("Invalid display type!");
                break;
        }
    }

    public final void displayGate(String origin) {
        System.out.println(this.gateMap.get(origin).toString());
    }

    public final void displayQubit(String origin) {
        System.out.println(this.qubitMap.get(origin).getStateVectorHistory());
    }

    public final void displayStateVector(String origin) {
        Qubit qubit = this.qubitMap.get(origin);
        if (qubit == null) {
            System.out.println("Qubit " + origin + " does not exist!");
        } else {
            qubit.displayQubit();
        }
    }

    public final void displayToFile(String type, String origin, String target) {
        try {
            FileWriter fw = new FileWriter(target);
            switch (type) {
                case "statevector":
                    this.displayStateVector(origin, fw);
                    break;
                case "qubit":
                    this.displayQubit(origin, fw);
                    break;
                case "gate":
                    this.displayGate(origin, fw);
                    break;
                default:
                    System.out.println("Invalid display type!");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public final void displayGate(String origin, FileWriter fw) {
        try {
            fw.write(this.gateMap.get(origin).getGateId() + ": " + this.gateMap.get(origin).getGateMatrix() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void displayQubit(String origin, FileWriter fw) {
        try {
            fw.write(this.qubitMap.get(origin).getStateVectorHistory() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final void displayStateVector(String origin, FileWriter fw) {
        Qubit qubit = this.qubitMap.get(origin);
        if (qubit == null) {
            System.out.println("Qubit " + origin + " does not exist!");
        } else {
            try {
                fw.write(qubit.getStateVectorHistory() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final void parseAdd(Line<String> line) {
        String type = line.getInstructionTree().getTypeToken().getData();
        String target = line.getInstructionTree().getTargetToken().getData();
        String origin = line.getInstructionTree().getOriginToken().getData();
        switch(type) {
            case "circuit":
                this.circuitMap.put(
                    origin, 
                    new QuantumCircuit()
                );
                break;
            case "qubit":
                //creating qubit into map using origin as key in state 0
                this.qubitMap.put(
                    origin, 
                    new Qubit(0)
                );
                //pushing qubit into circuit using circuit's target as key
                this.circuitMap.get(
                    target
                ).addQubit(this.qubitMap.get(
                    origin
                ));
                break;
            case "gate":
                this.parseGate(line.getInstructionTree());
                break;
            default:
                System.out.println("Invalid type!");
                break;
        }
    }

    public final void parseGate(SyntaxTree<String> syntaxTree) {
        String gateName = syntaxTree.getOriginToken().getData();
        String target = syntaxTree.getTargetToken().getData();
        switch(gateName) {
            case "hadamard":
                this.gateMap.put(
                    gateName, 
                    new Hadamard()
                );

                this.qubitMap.get(
                    target
                ).addGate(this.gateMap.get(
                    gateName
                ));

                break;
            case "paulix":
                this.gateMap.put(
                    gateName, 
                    new PauliX()
                );

                this.qubitMap.get(
                    target
                ).addGate(this.gateMap.get(
                    gateName
                ));

                break;
            case "pauliy":
                this.gateMap.put(
                    gateName, 
                    new PauliY()
                );

                this.qubitMap.get(
                    target
                ).addGate(this.gateMap.get(
                    gateName
                ));

                break;
            case "pauliz":
                this.gateMap.put(
                    gateName, 
                    new PauliZ()
                );

                this.qubitMap.get(
                    target
                ).addGate(this.gateMap.get(
                    gateName
                ));

                break;
            case "phase":
                this.gateMap.put(
                    gateName, 
                    new Phase()
                );

                this.qubitMap.get(
                    target
                ).addGate(this.gateMap.get(
                    gateName
                ));

                break;
            /*
            case "controlledNot":
                this.gateMap.put(
                    gateName, 
                    new ControlledNot()
                );
                break;
            case "controlledPhaseShift":
                this.gateMap.put(
                    gateName, 
                    new ControlledPhaseShift()
                );
                break;
            case "controlledHadamard":
                this.gateMap.put(
                    gateName, 
                    new ControlledHadamard()
                );
                break;
            case "controlledPauliX":
                this.gateMap.put(
                    gateName, 
                    new ControlledPauliX()
                );
                break;
            case "controlledPauliY":
                this.gateMap.put(
                    gateName, 
                    new ControlledPauliY()
                );
                break;
            case "controlledPauliZ":
                this.gateMap.put(
                    gateName, 
                    new ControlledPauliZ()
                );
                break;
            */
            default:
                System.out.println("Invalid Gate!");
                break;
        }
    }

    public static void terminateAllProcesses() {
        System.out.println("Forcefully terminating all processes...");
        System.exit(0);
    }
    
}
