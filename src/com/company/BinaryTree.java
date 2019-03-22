package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Código extraído del libro Java Structures y modificado por mí.
 *
 */

public class BinaryTree {

    Node root;

    public void add(Association<String,String> value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, Association<String,String> value) {

        if (current == null) {
            return new Node(value);
        }

        if (value.getKey().compareTo(current.value.getKey()) < 0) {
            current.left = addRecursive(current.left, value);
        } else if (value.getKey().compareTo(current.value.getKey()) > 0) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    public boolean containsNode(Association<String,String> value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, Association<String,String> value) {
        if (current == null) {
            return false;
        }

        if (value.getKey().equals(current.value.getKey())) {
            return true;
        }

        return value.getKey().compareTo(current.value.getKey()) < 0
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }



    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }

    class Node {
        Association<String, String> value;
        Node left;
        Node right;

        Node(Association<String, String> value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
