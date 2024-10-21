package org.objectGeneration.testingLite;

public class QualityComparator implements Comparison {
    @Override
    public boolean isBetterThan(CodeTest yourTest, CodeTest defaultTest) {
        return yourTest.getCodeQuality() >= defaultTest.getCodeQuality();
    }
}

