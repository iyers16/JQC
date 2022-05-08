package com.example.jqc.interfaces;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.example.jqc.compiler.Line;
import com.example.jqc.compiler.SyntaxTree;

public interface FileInterpreterInterface {
    public void execute(ArrayList<Line<String>> lines) 
                            throws IllegalArgumentException, 
                            IOException;

    public void parseAction(String a, 
                            Line<String> line) 
                            throws IOException, 
                            IllegalArgumentException;

    public void parseAdd(Line<String> line);

    public void parseDisplay(Line<String> line) 
                            throws IOException, 
                            IllegalArgumentException;

    public void displayToCLI(String type, String origin);

    public void displayToFile(String type, 
                            String origin, 
                            String target) 
                            throws IOException, 
                            IllegalArgumentException;

    public void displayGate(String origin);
    public void displayQubit(String origin);
    public void displayStateVector(String origin);

    public void displayGate(String origin, 
                            FileWriter fw) 
                            throws IOException;

    public void displayQubit(String origin, 
                            FileWriter fw) 
                            throws IOException;

    public void displayStateVector(String origin, 
                            FileWriter fw) 
                            throws IOException;

    public void parseGate(SyntaxTree<String> syntaxTree);




}
