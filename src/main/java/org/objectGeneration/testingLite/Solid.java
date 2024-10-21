package org.objectGeneration.testingLite;

public class Solid {
    private int singleResponsibilityScore;
    private int openClosedScore;
    private int liskovSubstitutionScore;
    private int interfaceSegregationScore;
    private int dependencyInversionScore;

    // Getters and setters

    public int getSingleResponsibilityScore() {
        return singleResponsibilityScore;
    }

    public void setSingleResponsibilityScore(int singleResponsibilityScore) {
        this.singleResponsibilityScore = singleResponsibilityScore;
    }

    public int getOpenClosedScore() {
        return openClosedScore;
    }

    public void setOpenClosedScore(int openClosedScore) {
        this.openClosedScore = openClosedScore;
    }

    public int getLiskovSubstitutionScore() {
        return liskovSubstitutionScore;
    }

    public void setLiskovSubstitutionScore(int liskovSubstitutionScore) {
        this.liskovSubstitutionScore = liskovSubstitutionScore;
    }

    public int getInterfaceSegregationScore() {
        return interfaceSegregationScore;
    }

    public void setInterfaceSegregationScore(int interfaceSegregationScore) {
        this.interfaceSegregationScore = interfaceSegregationScore;
    }

    public int getDependencyInversionScore() {
        return dependencyInversionScore;
    }

    public void setDependencyInversionScore(int dependencyInversionScore) {
        this.dependencyInversionScore = dependencyInversionScore;
    }
}
