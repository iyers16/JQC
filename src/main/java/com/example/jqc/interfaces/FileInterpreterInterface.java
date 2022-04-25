package com.example.jqc.interfaces;

import java.io.FileWriter;
import java.util.ArrayList;

import com.example.jqc.compiler.Line;
import com.example.jqc.compiler.SyntaxTree;

public interface FileInterpreterInterface {
    public void execute(ArrayList<Line<String>> lines);

    public void parseAction(String a, Line<String> line);

    public void parseAdd(Line<String> line);

    public void parseDisplay(Line<String> line);
    public void displayToCLI(String type, String origin);
    public void displayToFile(String type, String origin, String target);
    public void displayGate(String origin);
    public void displayQubit(String origin);
    public void displayStateVector(String origin);
    public void displayGate(String origin, FileWriter fw);
    public void displayQubit(String origin, FileWriter fw);
    public void displayStateVector(String origin, FileWriter fw);

    public void parseGate(SyntaxTree<String> syntaxTree);




}
