package com.example.jqc.compiler;

public class SyntaxTree<T> {
    private Node<T> actionToken;
    private Node<T> typeToken;
    private Node<T> originToken;
    private Node<T> targetToken;

    public SyntaxTree() {
        this.actionToken = new Node<T>();
        this.typeToken = new Node<T>();
        this.originToken = new Node<T>();
        this.targetToken = new Node<T>();
    }

    public SyntaxTree(T fullLine) {
        this.populateSyntaxTree(fullLine);
    }

    @SuppressWarnings("unchecked")
    public final void populateSyntaxTree(T fullLine) {
        try {
            T[] tokens = (T[]) ((String) fullLine).split(" ");
            this.setActionToken(new Node<>(tokens[0]));
            this.setTypeToken(new Node<>(tokens[1]));
            this.setOriginToken(new Node<>(tokens[2]));
            this.setTargetToken(new Node<>(tokens[3]));
            // Node<T> root = new Node<>(tokens[0]);
            // root.setLeftChild(new Node<>(tokens[1]));
            // root.setRightChild(new Node<>(tokens[3]));
            // root.getLeftChild().setLeftChild(new Node<>(tokens[2]));
            // this.root = root;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //               root            |                   action            |
    //     l                   r     |        type                    target     |
    // l        r         l        r |origin        null         null        null  |


    public final Node<T> getActionToken() {
        return this.actionToken;
    }

    public final void setActionToken(Node<T> actionToken) {
        this.actionToken = actionToken;
    }

    public final Node<T> getTypeToken() {
        return this.typeToken;
    }

    public final void setTypeToken(Node<T> typeToken) {
        this.typeToken = typeToken;
        this.actionToken.setLeftChild(this.typeToken);
    }

    public final Node<T> getOriginToken() {
        return this.originToken;
    }

    public final void setOriginToken(Node<T> originToken) {
        this.originToken = originToken;
        this.actionToken.getLeftChild().setRightChild(this.originToken);
    }

    public final Node<T> getTargetToken() {
        return this.targetToken;
    }

    public final void setTargetToken(Node<T> targetToken) {
        this.targetToken = targetToken;
        this.actionToken.setRightChild(this.targetToken);
    }

    public final void displaySyntaxTree() {
        this.displaySyntaxTree(this.actionToken);
    }

    public final void displaySyntaxTree(Node<T> node) {
        if (node != null) {
            System.out.println(node.getData());
            this.displaySyntaxTree(node.getLeftChild());
            this.displaySyntaxTree(node.getRightChild());
        }
    }

}