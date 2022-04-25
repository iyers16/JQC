package com.example.jqc.compiler;

public class Line<T> {
    private T bruteFullLine;
    private SyntaxTree<T> instructionTree;

    public Line(T fullLine) {
        this.bruteFullLine = fullLine;
        this.instructionTree = new SyntaxTree<>(fullLine);
    }

    public final T getBruteFullLine() {
        return this.bruteFullLine;
    }

    public final void setBruteFullLine(T fullLine) {
        this.bruteFullLine = fullLine;
    }

    public final SyntaxTree<T> getInstructionTree() {
        return this.instructionTree;
    }

    public final void setInstructionTree(SyntaxTree<T> instructionTree) {
        this.instructionTree = instructionTree;
    }
}