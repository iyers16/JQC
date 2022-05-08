package com.example.jqc;

import java.util.Scanner;

import com.example.jqc.compiler.FileInterpreter;
import com.example.jqc.compiler.FileParser;

public class Main {
    //Compilation command javac *.java
    //Execution command java Main main.jqc
    public static void main(String[] args) {
        System.out.println("\n\nWelcome to JQC\n\n");
        System.out.print("Provide valid absolute file path to JQC code file (by default it will select the main.jqc file in the same folder as your Main.java): ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        String defaultFileName = "/home/iyers16/Programs/JQC/jqc/src/main/java/com/example/jqc/main.jqc";


        if(fileName.equals("") 
            || fileName.isBlank() 
            || fileName.isEmpty() 
            || fileName.equals(" ") 
            || fileName.equals("\n")) {
            fileName = defaultFileName;
        }
        scanner.close();

        try {
            FileParser parser = new FileParser(fileName);
            FileInterpreter interpreter = new FileInterpreter();
            interpreter.execute(parser.getLineStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}