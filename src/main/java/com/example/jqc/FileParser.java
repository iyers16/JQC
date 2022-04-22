package com.example.jqc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import com.example.jqc.interfaces.FileParserInterface;

public class FileParser {
    private String fullPath;
    private String fileName;
    private File file;
    private FileInputStream fis;
    private FileOutputStream fos;
    private Line line;

    public FileParser(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.file = new File(this.fileName);

        if (!this.file.exists()) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        }

        this.fullPath = this.file.getAbsolutePath();        
    }

    public void loadFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.file = new File(this.fileName);

        if (!this.file.exists()) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        }

        this.fullPath = this.file.getAbsolutePath();
    }

     
    public void readFile(String filename) throws FileNotFoundException, IOException {    
        try {
            fis = new FileInputStream(this.fileName);

            //while not reach end of file, parse line
            while (fis.available() > 0) {
                this.buildAbstractSyntaxTree(fis);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File \"" + this.fileName +"\" not found");
        } catch (IOException e) {
            throw new IOException("Error reading file \"" + this.fileName +"\"");
        }
        
    }

     
    public void buildAbstractSyntaxTree(FileInputStream fis) throws IOException {
        String fullLine = "";
        String[] tokens = new String[4];

        //read line
        int c;
        while ((c = fis.read()) != '\n') {
            fullLine += (char)c;
        }

        //tokenize line
        tokens = fullLine.split(" ");
        this.line = new Line(tokens);     
    }

     
    public void interpretLine() {
        // TODO Auto-generated method stub
        
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    // private String fileName;
    // private String fileContent;

    // public FileParser(String fileName) {
    //     this.fileName = fileName;
    // }

    // public String getFileName() {
    //     return fileName;
    // }

    // public void setFileName(String fileName) {
    //     this.fileName = fileName;
    // }

    // public String getFileContent() {
    //     return fileContent;
    // }

    // public void setFileContent(String fileContent) {
    //     this.fileContent = fileContent;
    // }

    //  
    // public String toString() {
    //     return "FileParser{" +
    //             "fileName='" + fileName + '\'' +
    //             ", fileContent='" + fileContent + '\'' +
    //             '}';
    // }

    
}
