package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static String menu = "MENÚ: \n" +
            "\t 1. Cargar diccionario al árbol. \n" +
            "\t 2. Traducir texto. \n" +
            "\t 3. Salir del programa.";

    public static void main(String[] args) {

        boolean wantsToContinue = true;
        Scanner input = new Scanner(System.in);
        BinaryTree myTree = new BinaryTree();
        List<Association<String,String>> data = new ArrayList<>();

        do {
            System.out.println(menu);

            int option = input.nextInt();
            switch (option) {
                case 1: {
                    System.out.print("Ingrese el archivo de texto que desea procesar: ");
                    String userFile = input.nextLine();
                    userFile = input.nextLine();

                    try {
                        Stream<String> lines = Files.lines(
                                Paths.get(userFile),
                                StandardCharsets.UTF_8
                        );
                        lines.forEach(line -> {
                            String[] parts = line.replace("(", "").replace(")", "").replace(",", "").split(" ");

                            for (String i : parts) {
                                i = i.toUpperCase();
                            }

                            if (parts.length == 2) {
                                Association<String, String> element = new Association<>(parts[0], parts[1]);
                                System.out.println(element);
                                data.add(element);
                                myTree.add(element);

                            }
                        });
                    } catch (
                            IOException exception) {
                        System.out.println("Error!");
                    }
                    myTree.traverseInOrder(myTree.root);
                    break;
                }

                case 2: {
                    System.out.print("Ingrese el archivo de texto que desea procesar: ");
                    String userFile = input.nextLine();
                    userFile = input.nextLine();

                    try {
                        Stream<String> lines = Files.lines(
                                Paths.get(userFile),
                                StandardCharsets.UTF_8
                        );
                        lines.forEach(line -> {
                            String[] parts = line.replace("(", "").replace(")", "").replace(",", "").split(" ");

                            for (String i : parts) {
                                i = i.toUpperCase();
                                for (Association<String,String> x: data){
                                    if (i.equals(x.getKey().toUpperCase())){
                                        System.out.println(x.getValue());
                                    } else {
                                        System.out.println("*" + i + "*");
                                    }
                                }
                            }

                        });
                    } catch (
                            IOException exception) {
                        System.out.println("Error!");
                    }
                    myTree.traverseInOrder(myTree.root);
                    break;
                }

                case 3: {
                    wantsToContinue = false;
                    break;
                }
            }

        } while (wantsToContinue);
    }
}
