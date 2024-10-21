package org.objectGeneration.testingLite;

import java.util.HashMap;
import java.util.Map;

public class DefaultLanguageExtractor implements LanguageExtractor {
    private Map<String, String> languageMap;

    public DefaultLanguageExtractor() {
        languageMap = new HashMap<>();
        languageMap.put(".go", "Go");
        languageMap.put(".py", "Python");
        languageMap.put(".js", "JavaScript");
        languageMap.put(".java", "Java");
        languageMap.put(".cpp", "C++");
        languageMap.put(".rb", "Ruby");
        languageMap.put(".ts", "TypeScript");
        languageMap.put(".rs", "Rust");
        // Additional languages can be added here
    }

    public void addLanguage(String extension, String language) {
        languageMap.put(extension, language);
    }

    @Override
    public String extractLanguage(String fileName) {
        String ext = getFileExtension(fileName);
        return languageMap.getOrDefault(ext, "Unknown");
    }

    private String getFileExtension(String fileName) {
        int index = fileName.lastIndexOf('.');
        return index == -1 ? "" : fileName.substring(index);
    }
}

