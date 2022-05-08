package com.example.jqc.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.example.jqc.interfaces.FileParserInterface;


public class FileParser implements FileParserInterface {
    private String fullPath;
    private String fileName;
    private File file;
    private ArrayList<Line<String>> lineStream;

    public FileParser(String fileName) throws FileNotFoundException, IOException {
        this.loadFile(fileName);      
    }

    public final void loadFile(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
        this.file = new File(this.fileName);

        if (!this.file.exists()) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        }

        this.fullPath = this.file.getAbsolutePath();
        this.readFile(this.fullPath);
    }

     
    private final void readFile(String filename) throws FileNotFoundException, IOException {  
        this.lineStream = new ArrayList<Line<String>>();

        try (Stream<String> lines = Files
            .lines(Path.of(filename))) {
            lines.forEach((line) -> {
                // System.out.println(line);
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

    public final Line<String> buildAbstractSyntaxTree(String line) throws IOException {
        return new Line<>(line);
    }

    
    //getters and setters
    public final String getFullPath() {
        return this.fullPath;
    }

    public final void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public final File getFile() {
        return this.file;
    }

    public final void setFile(File file) {
        this.file = file;
    }

    public final ArrayList<Line<String>> getLineStream() {
        return this.lineStream;
    }

    public final void setLineStream(ArrayList<Line<String>> lineStream) {
        this.lineStream = lineStream;
    }    
}
