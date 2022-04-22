package com.example.jqc;

public class Line {
    private String fullLine;
    BinaryTree instructionTree;

    public Line(String[] tokens) {
        fullLine = "";
        for (int i = 0; i < tokens.length; i++) {
            fullLine += tokens[i] + " ";
        }
        Node rootNode = BinaryTree.populateSyntaxTree(fullLine);
        instructionTree = new BinaryTree(rootNode);
    }

    public Line(String fullLine) {
        this.fullLine = fullLine;
        Node rootNode = BinaryTree.populateSyntaxTree(fullLine);
        instructionTree = new BinaryTree(rootNode);
    }

    public String getFullLine() {
        return fullLine;
    }

    public void setFullLine(String fullLine) {
        this.fullLine = fullLine;
    }    
}
