package com.example.jqc;

public class Line<T> {
    private T bruteFullLine;
    private SyntaxTree<T> instructionTree;

    public Line(T fullLine) {
        this.bruteFullLine = fullLine;
        this.instructionTree = new SyntaxTree<>(fullLine);
    }

    public T getBruteFullLine() {
        return this.bruteFullLine;
    }

    public void setBruteFullLine(T fullLine) {
        this.bruteFullLine = fullLine;
    }

    public SyntaxTree<T> getInstructionTree() {
        return this.instructionTree;
    }

    public void setInstructionTree(SyntaxTree<T> instructionTree) {
        this.instructionTree = instructionTree;
    }
}