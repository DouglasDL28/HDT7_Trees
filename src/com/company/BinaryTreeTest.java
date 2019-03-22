package com.company;

import org.junit.Assert;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @org.junit.Test
    public void add() {
        BinaryTree tree = new BinaryTree();
        Association<String, String> test = new Association<>("Hello", "Hola");

        tree.add(test);
        System.out.println(tree.root.value);
    }

    @org.junit.Test
    public void traverseInOrder() {
        BinaryTree tree = new BinaryTree();

        tree.add(new Association<>("Hello", "Hola"));
        tree.add(new Association<>("Goodbye", "Adios"));
        tree.add(new Association<>("Dog", "perro"));
        tree.add(new Association<>("Woman", "mujer"));

        tree.traverseInOrder(tree.root);
    }
}