package org.objectGeneration.testingLite;

public class SecurityComparator implements Comparison {
    @Override
    public boolean isBetterThan(CodeTest yourTest, CodeTest defaultTest) {
        if (yourTest.getSecurity() == null || defaultTest.getSecurity() == null) {
            return true;
        }

        return yourTest.getSecurity().getLowSeverity() <= defaultTest.getSecurity().getLowSeverity() &&
                yourTest.getSecurity().getMediumSeverity() <= defaultTest.getSecurity().getMediumSeverity() &&
                yourTest.getSecurity().getHighSeverity() <= defaultTest.getSecurity().getHighSeverity() &&
                yourTest.getSecurity().getCriticalSeverity() <= defaultTest.getSecurity().getCriticalSeverity();
    }
}

