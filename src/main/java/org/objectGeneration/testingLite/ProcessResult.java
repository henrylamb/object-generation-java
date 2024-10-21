package org.objectGeneration.testingLite;

import org.objectGeneration.jsonSchema.Definition;

public class ProcessResult {
    private Definition codeQA;
    private String combinedCodeText;

    public ProcessResult(Definition codeQA, String combinedCodeText) {
        this.codeQA = codeQA;
        this.combinedCodeText = combinedCodeText;
    }

    public Definition getCodeQA() {
        return codeQA;
    }

    public String getCombinedCodeText() {
        return combinedCodeText;
    }
}

