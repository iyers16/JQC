package com.example.jqc;

public interface FileParser {

    void loadFile(String fileName);

    void readFile(String filename);

    void parseLine();
    
    void tokenizeLine();

    void buildAbstractSyntaxTree();

    void interpretLine();
        
}
