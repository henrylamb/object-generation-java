package org.objectGeneration.testingLite;

public class SuccessProbabilityComparator implements Comparison {
    @Override
    public boolean isBetterThan(CodeTest yourTest, CodeTest defaultTest) {
        return yourTest.getProbabilityOfSuccess() >= defaultTest.getProbabilityOfSuccess();
    }
}

