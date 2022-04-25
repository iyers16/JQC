package com.example.jqc;

import com.example.jqc.compiler.FileInterpreter;
import com.example.jqc.compiler.FileParser;

public class Main {
    //Compilation command javac *.java
    //Execution command java Main main.jqc
    public static void main(String[] args) {

        try {
            FileParser parser = new FileParser("/home/iyers16/Programs/JQC/jqc/src/main/java/com/example/jqc/main.jqc");
            FileInterpreter interpreter = new FileInterpreter();
            interpreter.execute(parser.getLineStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}