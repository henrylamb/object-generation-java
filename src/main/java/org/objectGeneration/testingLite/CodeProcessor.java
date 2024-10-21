package org.objectGeneration.testingLite;

import org.objectGeneration.jsonSchema.ModelType;

public interface CodeProcessor {
    ProcessResult processCode(String assumption, String filePath, String model) throws Exception;
}

