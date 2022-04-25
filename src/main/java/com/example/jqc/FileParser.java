package com.example.jqc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;


public class FileParser {
    private String fullPath;
    private String fileName;
    private File file;
    private ArrayList<Line<String>> lineStream;

    public FileParser(String fileName) throws FileNotFoundException, IOException {
        this.loadFile(fileName);      
    }

    public void loadFile(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
        this.file = new File(this.fileName);

        if (!this.file.exists()) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        }

        this.fullPath = this.file.getAbsolutePath();
        this.readFile(this.fullPath);
    }

     
    private void readFile(String filename) throws FileNotFoundException, IOException {  
        this.lineStream = new ArrayList<Line<String>>();

        try (Stream<String> lines = Files
            .lines(Path.of(filename))) {
            lines.forEach((line) -> {
                System.out.println(line);
                try {
                    Line<String> lineObj = this.buildAbstractSyntaxTree(line);
                    this.lineStream.add(lineObj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        } catch (IOException e) {
            throw new IOException("Error reading file \"" + this.fileName +"\"");
        }
    }

    public Line<String> buildAbstractSyntaxTree(String line) throws IOException {
        return new Line<>(line);
    }

    public String getFullPath() {
        return this.fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ArrayList<Line<String>> getLineStream() {
        return this.lineStream;
    }

    public void setLineStream(ArrayList<Line<String>> lineStream) {
        this.lineStream = lineStream;
    }    
}
