package org.objectGeneration.testingLite;

import org.objectGeneration.jsonSchema.DataType;
import org.objectGeneration.jsonSchema.Definition;
import org.objectGeneration.jsonSchema.ModelType;

import java.util.*;

public class DefaultCodeProcessor implements CodeProcessor {
    private LanguageExtractor extractor;
    private FileProcessor fileProcessor;

    public DefaultCodeProcessor() {
        this.extractor = new DefaultLanguageExtractor();
        this.fileProcessor = new FileProcessor();
    }

    public ProcessResult processCode(String assumption, String filePath, String model) throws Exception {
        Set<String> languageSet = new HashSet<>();
        StringBuilder combinedCodeText = new StringBuilder();

        // Extract file contents
        Map<String, String> fileContents = fileProcessor.extractFileContents(filePath);

        for (Map.Entry<String, String> entry : fileContents.entrySet()) {
            String fileName = entry.getKey();
            String codeText = entry.getValue();
            String language = extractor.extractLanguage(fileName);

            if (!language.equals("Unknown")) {
                languageSet.add(language);
            }

            combinedCodeText.append(String.format("\n\n// Start of File: %s\n", fileName));
            combinedCodeText.append(codeText);
            combinedCodeText.append("\n// End of File\n");
        }

        List<String> languageList = new ArrayList<>(languageSet);
        String language = String.join(", ", languageList);

        String systemPromptGeneral = String.format(
                "You are an expert in the following programming languages: %s. You are tasked with reviewing code for overall quality, maintainability, best practices, and integration between these languages. The separate files are all merged together, do not fault the code for being structured like this.",
                language
        );

        // Construct the system prompts for each section
        String systemPromptReview = String.format("You are reviewing the code written in %s, and you should provide detailed feedback on its structure, readability, and maintainability.", language);
        String systemPromptSecurity = String.format("You are evaluating the security aspects of the code written in %s, identifying vulnerabilities and potential risks.", language);
        String systemPromptSuccess = String.format("You are estimating the probability of successful deployment for the code written in %s without significant issues.", language);

        // Create the codeQA Definition object
        Definition codeQA = new Definition();
        codeQA.setType(DataType.OBJECT);
        codeQA.setInstruction(String.format("Analyze the overall quality of the provided code and provide a summary evaluation. \n\n %s", assumption));
        codeQA.setSystemPrompt(systemPromptGeneral);
        codeQA.setModel(model);

        Map<String, Definition> properties = new HashMap<>();

        // Add codeQuality property
        Definition codeQualityDef = new Definition();
        codeQualityDef.setType(DataType.NUMBER);
        codeQualityDef.setInstruction("Rate the overall quality of the code on a scale from 1 to 100, where 1 is poor and 100 is excellent.");
        properties.put("codeQuality", codeQualityDef);

        // Add review property
        Definition reviewDef = new Definition();
        reviewDef.setType(DataType.OBJECT);
        reviewDef.setSystemPrompt(systemPromptReview);
        reviewDef.setModel(model);
        reviewDef.setInstruction(String.format("Provide a detailed review of the code, including key strengths and weaknesses. \n\n %s", assumption));

        Map<String, Definition> reviewProps = new HashMap<>();
        Definition feedbackDef = new Definition();
        feedbackDef.setType(DataType.STRING);
        feedbackDef.setInstruction("Give specific feedback on the code’s structure, readability, maintainability, and any issues detected.");
        reviewProps.put("feedback", feedbackDef);

        reviewDef.setProperties(reviewProps);
        properties.put("review", reviewDef);

        // Add security property
        Definition securityDef = new Definition();
        securityDef.setType(DataType.OBJECT);
        securityDef.setInstruction(String.format("Evaluate the security of the code by analyzing vulnerabilities across severity levels. Each severity level (low, medium, high, and critical) must be reported based on actual, observable issues. If no vulnerabilities of a certain severity level are present, report a value of 0. Make sure to differentiate clearly between theoretical risks and actual vulnerabilities present in the code.\n\n%s", assumption));
        securityDef.setSystemPrompt(systemPromptSecurity);
        securityDef.setModel(model);
        securityDef.setSelectFields(Arrays.asList("review"));

        Map<String, Definition> securityProps = new HashMap<>();
        securityProps.put("lowSeverity", createSeverityDefinition("low", "minor", "Low-severity vulnerabilities represent small risks, typically minor misconfigurations or low-impact issues."));
        securityProps.put("mediumSeverity", createSeverityDefinition("medium", "significant", "Medium-severity vulnerabilities could be exploited in specific circumstances, potentially leading to unauthorized access."));
        securityProps.put("highSeverity", createSeverityDefinition("high", "severe", "High-severity vulnerabilities can result in significant impacts, such as unauthorized access to sensitive data."));
        securityProps.put("criticalSeverity", createSeverityDefinition("critical", "critical", "Critical-severity vulnerabilities represent the most severe risks, allowing for complete system compromise."));

        securityDef.setProperties(securityProps);
        properties.put("security", securityDef);

        // Add probabilityOfSuccess property
        Definition probabilityDef = new Definition();
        probabilityDef.setType(DataType.NUMBER);
        probabilityDef.setSystemPrompt(systemPromptSuccess);
        probabilityDef.setInstruction("Estimate the probability of the code’s successfully running given the context of the code provided, on a scale from 0 to 100.");
        properties.put("probabilityOfSuccess", probabilityDef);

        // Add solid property
        Definition solidDef = new Definition();
        solidDef.setType(DataType.OBJECT);
        solidDef.setInstruction(String.format("Evaluate the code based on the five SOLID principles (Single Responsibility, Open/Closed, Liskov Substitution, Interface Segregation, Dependency Inversion). Rate each principle from 0 to 100, where 10 is poor adherence and 90 is excellent adherence. \n\n %s", assumption));
        solidDef.setModel(model);
        solidDef.setSystemPrompt(systemPromptGeneral);

        Map<String, Definition> solidProps = new HashMap<>();
        solidProps.put("singleResponsibilityScore", createSolidDefinition("Single Responsibility Principle", "Rate the code’s adherence to the SRP."));
        solidProps.put("openClosedScore", createSolidDefinition("Open/Closed Principle", "Rate the code’s adherence to the OCP."));
        solidProps.put("liskovSubstitutionScore", createSolidDefinition("Liskov Substitution Principle", "Rate the code’s adherence to the LSP."));
        solidProps.put("interfaceSegregationScore", createSolidDefinition("Interface Segregation Principle", "Rate the code’s adherence to the ISP."));
        solidProps.put("dependencyInversionScore", createSolidDefinition("Dependency Inversion Principle", "Rate the code’s adherence to the DIP."));

        solidDef.setProperties(solidProps);
        properties.put("solid", solidDef);

        codeQA.setProperties(properties);

        return new ProcessResult(codeQA, combinedCodeText.toString());
    }

    private Definition createSeverityDefinition(String severity, String impact, String description) {
        Definition def = new Definition();
        def.setType(DataType.NUMBER);
        def.setInstruction(String.format(
                "Identify the number of %s-severity security vulnerabilities found in the integrated code. These represent %s risks and are typically described as follows:\n\n%s\n\nOnly report observable issues. Return a value of 0 if none are found.",
                severity, impact, description
        ));
        return def;
    }

    private Definition createSolidDefinition(String principle, String instruction) {
        Definition def = new Definition();
        def.setType(DataType.NUMBER);
        def.setInstruction(instruction);
        return def;
    }
}
