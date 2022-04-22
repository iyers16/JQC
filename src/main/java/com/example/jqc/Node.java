package com.example.jqc;

public class Node {
    private String data;
    private Node leftChild;
    private Node rightChild;

    public Node(String data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void appendChild(String data) {
        Node newChild = new Node(data);
        if (this.leftChild == null) {
            this.leftChild = newChild;
        } else {
            this.rightChild = newChild;
        }
    }

    public String getData() {
        return this.data;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return this.data;
    }

    public void displayNode() {
        System.out.println(this.data);
    }


    
}
