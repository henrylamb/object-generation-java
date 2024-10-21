package org.objectGeneration.testingLite;

public class EvaluateGrade {
    public static String evaluateGrade(CodeTest testVal) {
        if (TestComparison.testComparison(testVal, DefaultTests.ExtremeTesting)) {
            return "A*";
        } else if (TestComparison.testComparison(testVal, DefaultTests.StrictTesting)) {
            return "A";
        } else if (TestComparison.testComparison(testVal, DefaultTests.ModerateTesting)) {
            return "B";
        } else if (TestComparison.testComparison(testVal, DefaultTests.LenientTesting)) {
            return "C";
        } else if (TestComparison.testComparison(testVal, DefaultTests.KindTesting)) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void printResult(String grade, CodeTest testVal, boolean verbose) {
        if (verbose) {
            System.out.println("Grade: " + grade);
            System.out.println("Code Quality: " + testVal.getCodeQuality());
            System.out.println("Probability of Success: " + testVal.getProbabilityOfSuccess());
            System.out.printf("Security: Low Severity: %d, Medium Severity: %d, High Severity: %d, Critical Severity: %d\n",
                    testVal.getSecurity().getLowSeverity(), testVal.getSecurity().getMediumSeverity(),
                    testVal.getSecurity().getHighSeverity(), testVal.getSecurity().getCriticalSeverity());
            System.out.printf("SOLID Scores: SRP: %d, OCP: %d, LSP: %d, ISP: %d, DIP: %d\n",
                    testVal.getSolid().getSingleResponsibilityScore(), testVal.getSolid().getOpenClosedScore(),
                    testVal.getSolid().getLiskovSubstitutionScore(), testVal.getSolid().getInterfaceSegregationScore(),
                    testVal.getSolid().getDependencyInversionScore());
        } else {
            System.out.println("Grade: " + grade);
        }
    }
}

