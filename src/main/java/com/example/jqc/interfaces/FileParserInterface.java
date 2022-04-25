package com.example.jqc.interfaces;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.example.jqc.compiler.Line;

public interface FileParserInterface {
    public void loadFile(String fileName) throws FileNotFoundException, IOException;
    public Line<String> buildAbstractSyntaxTree(String line) throws IOException;

    //getters and setters interfaces
    public String getFullPath();
    public String getFileName();
    public File getFile();
    public ArrayList<Line<String>> getLineStream();
    
    public void setFullPath(String fullPath);
    public void setFileName(String fileName);
    public void setFile(File file);
    public void setLineStream(ArrayList<Line<String>> lineStream);
}
