package org.objectGeneration.testingLite;

public class TestingLiteUtils {

    // These values are the thresholds which can be used as defaults for your code to pass their tests

    // KindTesting represents the most relaxed evaluation thresholds
    public static CodeTest getKindTesting() {
        CodeTest kindTesting = new CodeTest();
        kindTesting.setCodeQuality(50);
        kindTesting.setProbabilityOfSuccess(40);

        Security security = new Security();
        security.setLowSeverity(15);
        security.setMediumSeverity(10);
        security.setHighSeverity(5);
        security.setCriticalSeverity(2);
        kindTesting.setSecurity(security);

        Solid solid = new Solid();
        solid.setSingleResponsibilityScore(30);
        solid.setOpenClosedScore(30);
        solid.setLiskovSubstitutionScore(30);
        solid.setInterfaceSegregationScore(30);
        solid.setDependencyInversionScore(30);
        kindTesting.setSolid(solid);

        return kindTesting;
    }

    // LenientTesting represents relaxed evaluation thresholds
    public static CodeTest getLenientTesting() {
        CodeTest lenientTesting = new CodeTest();
        lenientTesting.setCodeQuality(60);
        lenientTesting.setProbabilityOfSuccess(50);

        Security security = new Security();
        security.setLowSeverity(10);
        security.setMediumSeverity(5);
        security.setHighSeverity(3);
        security.setCriticalSeverity(1);
        lenientTesting.setSecurity(security);

        Solid solid = new Solid();
        solid.setSingleResponsibilityScore(50);
        solid.setOpenClosedScore(50);
        solid.setLiskovSubstitutionScore(50);
        solid.setInterfaceSegregationScore(50);
        solid.setDependencyInversionScore(50);
        lenientTesting.setSolid(solid);

        return lenientTesting;
    }

    // ModerateTesting represents a balanced evaluation with moderate thresholds
    public static CodeTest getModerateTesting() {
        CodeTest moderateTesting = new CodeTest();
        moderateTesting.setCodeQuality(70);
        moderateTesting.setProbabilityOfSuccess(70);

        Security security = new Security();
        security.setLowSeverity(5);
        security.setMediumSeverity(3);
        security.setHighSeverity(1);
        security.setCriticalSeverity(0);
        moderateTesting.setSecurity(security);

        Solid solid = new Solid();
        solid.setSingleResponsibilityScore(70);
        solid.setOpenClosedScore(70);
        solid.setLiskovSubstitutionScore(70);
        solid.setInterfaceSegregationScore(70);
        solid.setDependencyInversionScore(70);
        moderateTesting.setSolid(solid);

        return moderateTesting;
    }

    // StrictTesting represents stringent evaluation with strict thresholds
    public static CodeTest getStrictTesting() {
        CodeTest strictTesting = new CodeTest();
        strictTesting.setCodeQuality(80);
        strictTesting.setProbabilityOfSuccess(85);

        Security security = new Security();
        security.setLowSeverity(3);
        security.setMediumSeverity(1);
        security.setHighSeverity(0);
        security.setCriticalSeverity(0);
        strictTesting.setSecurity(security);

        Solid solid = new Solid();
        solid.setSingleResponsibilityScore(80);
        solid.setOpenClosedScore(80);
        solid.setLiskovSubstitutionScore(80);
        solid.setInterfaceSegregationScore(80);
        solid.setDependencyInversionScore(80);
        strictTesting.setSolid(solid);

        return strictTesting;
    }

    // ExtremeTesting represents the most stringent evaluation with strict thresholds
    public static CodeTest getExtremeTesting() {
        CodeTest extremeTesting = new CodeTest();
        extremeTesting.setCodeQuality(90);
        extremeTesting.setProbabilityOfSuccess(95);

        Security security = new Security();
        security.setLowSeverity(1);
        security.setMediumSeverity(0);
        security.setHighSeverity(0);
        security.setCriticalSeverity(0);
        extremeTesting.setSecurity(security);

        Solid solid = new Solid();
        solid.setSingleResponsibilityScore(95);
        solid.setOpenClosedScore(95);
        solid.setLiskovSubstitutionScore(95);
        solid.setInterfaceSegregationScore(95);
        solid.setDependencyInversionScore(95);
        extremeTesting.setSolid(solid);

        return extremeTesting;
    }
}

