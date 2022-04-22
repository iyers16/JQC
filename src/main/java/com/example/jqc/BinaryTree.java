package com.example.jqc;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public static Node populateSyntaxTree(String[] tokens) {
        Node root = new Node(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            root.appendChild(tokens[i]);
        }
        return root;
    }
    public static Node populateSyntaxTree(String fullLine) {
        String[] tokens = fullLine.split(" ");
        Node root = new Node(tokens[0]);
        for (int i = 1; i < tokens.length; i++) {
            root.appendChild(tokens[i]);
        }
        return root;
    }
    
}
