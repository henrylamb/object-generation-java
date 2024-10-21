package org.objectGeneration.testingLite;


public class SolidPrinciplesComparator implements Comparison {
    @Override
    public boolean isBetterThan(CodeTest yourTest, CodeTest defaultTest) {
        if (yourTest.getSolid() == null || defaultTest.getSolid() == null) {
            return true;
        }

        return yourTest.getSolid().getSingleResponsibilityScore() >= defaultTest.getSolid().getSingleResponsibilityScore() &&
                yourTest.getSolid().getOpenClosedScore() >= defaultTest.getSolid().getOpenClosedScore() &&
                yourTest.getSolid().getLiskovSubstitutionScore() >= defaultTest.getSolid().getLiskovSubstitutionScore() &&
                yourTest.getSolid().getInterfaceSegregationScore() >= defaultTest.getSolid().getInterfaceSegregationScore() &&
                yourTest.getSolid().getDependencyInversionScore() >= defaultTest.getSolid().getDependencyInversionScore();
    }
}

