package org.objectGeneration.testingLite;

import java.io.File;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class FileProcessor {

    public boolean isTestFile(String fileName) {
        return fileName.endsWith("_test.go") ||
                fileName.contains(".test.") ||
                fileName.contains(".spec.") ||
                fileName.endsWith("Test.java") ||
                fileName.endsWith("_test.py") ||
                fileName.endsWith("_test.rb") ||
                fileName.endsWith("Test.php") ||
                fileName.endsWith("_test.cpp") ||
                fileName.endsWith("Test.swift") ||
                fileName.endsWith("Test.kt") ||
                fileName.endsWith("_test.exs") ||
                fileName.endsWith("_test.cs") ||
                fileName.endsWith("Test.m") ||
                fileName.endsWith("Spec.groovy") ||
                fileName.endsWith("Test.groovy") ||
                fileName.endsWith("Test.scala") ||
                fileName.contains("test_") ||
                fileName.endsWith("Test.rb");
    }

    public Map<String, String> extractFileContents(String codePath) throws Exception {
        Map<String, String> fileContents = new HashMap<>();

        File codeFile = new File(codePath);
        if (!codeFile.exists()) {
            throw new Exception("Error accessing path: " + codePath);
        }

        if (codeFile.isDirectory()) {
            processDirectory(codePath, fileContents);
        } else {
            processFile(codePath, fileContents);
        }

        return fileContents;
    }

    public void processDirectory(String directoryPath, Map<String, String> fileContents) throws Exception {
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        if (files == null) {
            throw new Exception("Error reading directory: " + directoryPath);
        }

        for (File file : files) {
            if (!file.isDirectory()) {
                String filePath = file.getAbsolutePath();
                processFile(filePath, fileContents);
            }
        }
    }

    public void processFile(String filePath, Map<String, String> fileContents) throws Exception {
        String fileName = new File(filePath).getName();

        // Skip test files
        if (isTestFile(fileName)) {
            return;
        }

        // Read the file content
        String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        fileContents.put(fileName, content);
    }
}

