package org.objectGeneration.testingLite;

import java.util.Arrays;
import java.util.List;

public class TestComparison {
    public static boolean testComparison(CodeTest yourTest, CodeTest defaultTest) {
        List<Comparison> comparators = Arrays.asList(
                new QualityComparator(),
                new SuccessProbabilityComparator(),
                new SecurityComparator(),
                new SolidPrinciplesComparator()
        );

        for (Comparison comparator : comparators) {
            if (!comparator.isBetterThan(yourTest, defaultTest)) {
                return false;
            }
        }
        return true;
    }
}

