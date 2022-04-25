package com.example.jqc;

public class Node<T> {
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node() {
        this.data = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void appendChild(T data) {
        Node<T> newChild = new Node<>(data);
        if (this.leftChild == null) {
            this.leftChild = newChild;
        } else {
            this.rightChild = newChild;
        }
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getLeftChild() {
        return this.leftChild;
    }

    public Node<T> getRightChild() {
        return this.rightChild;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return (String) this.data;
    }

    public void displayNode() {
        System.out.println(this.data);
    }

}