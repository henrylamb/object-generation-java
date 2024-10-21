package org.objectGeneration.testingLite;

import org.objectGeneration.jsonSchema.ModelType;

public class TestConstructor {
    // TestConstructor separates code extraction and processing
    public static ProcessResult testConstructor(String assumption, String codePath, String model, CodeProcessor processor) throws Exception {
        return processor.processCode(assumption, codePath, model);
    }
}

