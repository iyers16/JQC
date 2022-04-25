package com.example.jqc.compiler;

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

    public final void appendChild(T data) {
        Node<T> newChild = new Node<>(data);
        if (this.leftChild == null) {
            this.leftChild = newChild;
        } else {
            this.rightChild = newChild;
        }
    }

    public final T getData() {
        return this.data;
    }

    public final Node<T> getLeftChild() {
        return this.leftChild;
    }

    public final Node<T> getRightChild() {
        return this.rightChild;
    }

    public final void setData(T data) {
        this.data = data;
    }

    public final void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public final void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public final String toString() {
        return (String) this.data;
    }

    public final void displayNode() {
        System.out.println(this.data);
    }

}