package org.objectGeneration.testingLite;

public class DefaultTests {
    public static final CodeTest KindTesting = new CodeTest();
    public static final CodeTest LenientTesting = new CodeTest();
    public static final CodeTest ModerateTesting = new CodeTest();
    public static final CodeTest StrictTesting = new CodeTest();
    public static final CodeTest ExtremeTesting = new CodeTest();

    static {
        // Initialize KindTesting
        KindTesting.setCodeQuality(50);
        KindTesting.setProbabilityOfSuccess(40);
        Security kindSecurity = new Security();
        kindSecurity.setLowSeverity(15);
        kindSecurity.setMediumSeverity(10);
        kindSecurity.setHighSeverity(5);
        kindSecurity.setCriticalSeverity(2);
        KindTesting.setSecurity(kindSecurity);
        Solid kindSolid = new Solid();
        kindSolid.setSingleResponsibilityScore(30);
        kindSolid.setOpenClosedScore(30);
        kindSolid.setLiskovSubstitutionScore(30);
        kindSolid.setInterfaceSegregationScore(30);
        kindSolid.setDependencyInversionScore(30);
        KindTesting.setSolid(kindSolid);

        // Initialize LenientTesting
        LenientTesting.setCodeQuality(60);
        LenientTesting.setProbabilityOfSuccess(50);
        Security lenientSecurity = new Security();
        lenientSecurity.setLowSeverity(10);
        lenientSecurity.setMediumSeverity(5);
        lenientSecurity.setHighSeverity(3);
        lenientSecurity.setCriticalSeverity(1);
        LenientTesting.setSecurity(lenientSecurity);
        Solid lenientSolid = new Solid();
        lenientSolid.setSingleResponsibilityScore(50);
        lenientSolid.setOpenClosedScore(50);
        lenientSolid.setLiskovSubstitutionScore(50);
        lenientSolid.setInterfaceSegregationScore(50);
        lenientSolid.setDependencyInversionScore(50);
        LenientTesting.setSolid(lenientSolid);

        // Initialize ModerateTesting
        ModerateTesting.setCodeQuality(70);
        ModerateTesting.setProbabilityOfSuccess(70);
        Security moderateSecurity = new Security();
        moderateSecurity.setLowSeverity(5);
        moderateSecurity.setMediumSeverity(3);
        moderateSecurity.setHighSeverity(1);
        moderateSecurity.setCriticalSeverity(0);
        ModerateTesting.setSecurity(moderateSecurity);
        Solid moderateSolid = new Solid();
        moderateSolid.setSingleResponsibilityScore(70);
        moderateSolid.setOpenClosedScore(70);
        moderateSolid.setLiskovSubstitutionScore(70);
        moderateSolid.setInterfaceSegregationScore(70);
        moderateSolid.setDependencyInversionScore(70);
        ModerateTesting.setSolid(moderateSolid);

        // Initialize StrictTesting
        StrictTesting.setCodeQuality(80);
        StrictTesting.setProbabilityOfSuccess(85);
        Security strictSecurity = new Security();
        strictSecurity.setLowSeverity(3);
        strictSecurity.setMediumSeverity(1);
        strictSecurity.setHighSeverity(0);
        strictSecurity.setCriticalSeverity(0);
        StrictTesting.setSecurity(strictSecurity);
        Solid strictSolid = new Solid();
        strictSolid.setSingleResponsibilityScore(80);
        strictSolid.setOpenClosedScore(80);
        strictSolid.setLiskovSubstitutionScore(80);
        strictSolid.setInterfaceSegregationScore(80);
        strictSolid.setDependencyInversionScore(80);
        StrictTesting.setSolid(strictSolid);

        // Initialize ExtremeTesting
        ExtremeTesting.setCodeQuality(90);
        ExtremeTesting.setProbabilityOfSuccess(95);
        Security extremeSecurity = new Security();
        extremeSecurity.setLowSeverity(1);
        extremeSecurity.setMediumSeverity(0);
        extremeSecurity.setHighSeverity(0);
        extremeSecurity.setCriticalSeverity(0);
        ExtremeTesting.setSecurity(extremeSecurity);
        Solid extremeSolid = new Solid();
        extremeSolid.setSingleResponsibilityScore(95);
        extremeSolid.setOpenClosedScore(95);
        extremeSolid.setLiskovSubstitutionScore(95);
        extremeSolid.setInterfaceSegregationScore(95);
        extremeSolid.setDependencyInversionScore(95);
        ExtremeTesting.setSolid(extremeSolid);
    }
}

