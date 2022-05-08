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

    public final void execute(ArrayList<Line<String>> lines) throws IllegalArgumentException, 
                                                            IOException, 
                                                            NullPointerException {
        
        try {
            for(Line<String> line : lines) {
                this.parseAction(
                    line.getInstructionTree().getActionToken().getData(), 
                    line
                );
            }
        } catch (NullPointerException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
    }

    public final void parseAction(String a, Line<String> line) throws IOException, 
                                                                IllegalArgumentException{
        
        try {
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
            }
        } catch(NullPointerException e) {
            throw e;
        } catch(IllegalArgumentException e) {
            throw e;
        }
    }


    public final void parseAdd(Line<String> line) throws NullPointerException, 
                                                        IllegalArgumentException {
        String type = line.getInstructionTree().getTypeToken().getData();
        String target = line.getInstructionTree().getTargetToken().getData();
        String origin = line.getInstructionTree().getOriginToken().getData();

        try {
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
                    QuantumCircuit circuit = this.circuitMap.get(target);
                    Qubit qubit = this.qubitMap.get(origin);
                    if(qubit == null) {
                        throw new NullPointerException("Invalid Qubit!");
                    } else if(circuit == null) {
                        throw new NullPointerException("Invalid Circuit!");
                    } else {
                        circuit.addQubit(qubit);
                    }
                    break;
                case "gate":
                    this.parseGate(line.getInstructionTree());
                    break;
                default:
                    System.out.println("Invalid type!");
                    throw new IllegalArgumentException("Invalid type!");
            }
        } catch (NullPointerException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        }    
    }

    public final void parseGate(SyntaxTree<String> syntaxTree) throws IllegalArgumentException,
                                                                NullPointerException {
        String gateName = syntaxTree.getOriginToken().getData();
        String target = syntaxTree.getTargetToken().getData();
        try {
            switch(gateName) {
            case "hadamard":
                this.gateMap.put(
                    gateName, 
                    new Hadamard()
                );

                Qubit tmph = this.qubitMap.get(
                    target
                );
                Gate tmpgh = this.gateMap.get(
                    gateName
                );

                if(tmph == null) {
                    throw new NullPointerException("Invalid qubit!");
                } else if(tmpgh == null) {
                    throw new NullPointerException("Invalid gate!");
                } else {
                    tmph.addGate(tmpgh);
                }
                break;
            case "paulix":
                this.gateMap.put(
                    gateName, 
                    new PauliX()
                );

                Qubit tmpx = this.qubitMap.get(
                    target
                );
                Gate tmpgx = this.gateMap.get(
                    gateName
                );

                if(tmpx == null) {
                    throw new NullPointerException("Invalid qubit!");
                } else if(tmpgx == null) {
                    throw new NullPointerException("Invalid gate!");
                } else {
                    tmpx.addGate(tmpgx);
                }
                break;
            case "pauliy":
                this.gateMap.put(
                    gateName, 
                    new PauliY()
                );

                Qubit tmpy = this.qubitMap.get(
                    target
                );
                Gate tmpgy = this.gateMap.get(
                    gateName
                );

                if(tmpy == null) {
                    throw new NullPointerException("Invalid qubit!");
                } else if(tmpgy == null) {
                    throw new NullPointerException("Invalid gate!");
                } else {
                    tmpy.addGate(tmpgy);
                }
                break;
            case "pauliz":
                this.gateMap.put(
                    gateName, 
                    new PauliZ()
                );

                Qubit tmpz = this.qubitMap.get(
                    target
                );
                Gate tmpgz = this.gateMap.get(
                    gateName
                );

                if(tmpz == null) {
                    throw new NullPointerException("Invalid qubit!");
                } else if(tmpgz == null) {
                    throw new NullPointerException("Invalid gate!");
                } else {
                    tmpz.addGate(tmpgz);
                }
                break;
            case "phase":
                this.gateMap.put(
                    gateName, 
                    new Phase()
                );

                Qubit tmpp = this.qubitMap.get(
                    target
                );
                Gate tmpgp = this.gateMap.get(
                    gateName
                );

                if(tmpp == null) {
                    throw new NullPointerException("Invalid qubit!");
                } else if(tmpgp == null) {
                    throw new NullPointerException("Invalid gate!");
                } else {
                    tmpp.addGate(tmpgp);
                }
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
                throw new IllegalArgumentException("Invalid Gate!");
        }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public final void parseDisplay(Line<String> line) throws IOException, 
                                                            NullPointerException, 
                                                            IllegalArgumentException {
        String type = line.getInstructionTree().getTypeToken().getData();
        String target = line.getInstructionTree().getTargetToken().getData();
        String origin = line.getInstructionTree().getOriginToken().getData();
        try {
            switch (target) {
                case "cli":
                    this.displayToCLI(type, origin);
                    break;
                case "file":
                    this.displayToFile(type, origin, target);
                    break;
                default:
                    System.out.println("Invalid target token!");
                    throw new IllegalArgumentException("Invalid target token!");
    
            }

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        }
        
	}

	public final void displayToCLI(String type, String origin) throws IllegalArgumentException {
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
                throw new IllegalArgumentException("Invalid display type!");
        }
    }

    public final void displayGate(String origin) throws NullPointerException{
        Gate gate = this.gateMap.get(origin);
        if(gate == null) {
            throw new NullPointerException("Gate not found!");
        } else {
            System.out.println(gate.toString());
        }
    }

    public final void displayQubit(String origin) throws NullPointerException{
        Qubit qubit = this.qubitMap.get(origin);
        if (qubit == null) {
            throw new NullPointerException("Qubit not found!");
        } else {
            System.out.println(qubit.getStateVectorHistory());
        }
        
    }

    public final void displayStateVector(String origin) throws NullPointerException{
        Qubit qubit = this.qubitMap.get(origin);
        if (qubit == null) {
            throw new NullPointerException("Invalid qubit!");
        } else {
            qubit.displayQubit();
        }
    }

    public final void displayToFile(String type, String origin, String target) throws IOException, NullPointerException, IllegalArgumentException {
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
                    fw.close();
                    throw new IllegalArgumentException("Invalid display type!");
            }
        } catch (IOException e) {
            throw e;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        }
        
    }

    public final void displayGate(String origin, FileWriter fw) throws IOException {
        try {
            fw.write(this.gateMap.get(origin).getGateId() + ": " + this.gateMap.get(origin).getGateMatrix() + "\n");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public final void displayQubit(String origin, FileWriter fw) throws IOException {
        try {
            fw.write(this.qubitMap.get(origin).getStateVectorHistory() + "\n");
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    public final void displayStateVector(String origin, FileWriter fw) throws IOException, NullPointerException {
        Qubit qubit = this.qubitMap.get(origin);
        if (qubit == null) {
            throw new NullPointerException("Invalid qubit!");
        } else {
            try {
                fw.write(qubit.getStateVectorHistory() + "\n");
            } catch (IOException e) {
                throw new IOException(e);
            }
        }
    }
    public static void terminateAllProcesses() {
        System.out.println("Forcefully terminating all processes...");
        System.exit(0);
    }
    
}
