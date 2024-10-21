package org.objectGeneration.testingLite;

public class CodeTest {
    private int codeQuality;
    private Solid solid;
    private Review review;
    private Security security;
    private int probabilityOfSuccess;

    // Getters and setters

    public int getCodeQuality() {
        return codeQuality;
    }

    public void setCodeQuality(int codeQuality) {
        this.codeQuality = codeQuality;
    }

    public Solid getSolid() {
        return solid;
    }

    public void setSolid(Solid solid) {
        this.solid = solid;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public int getProbabilityOfSuccess() {
        return probabilityOfSuccess;
    }

    public void setProbabilityOfSuccess(int probabilityOfSuccess) {
        this.probabilityOfSuccess = probabilityOfSuccess;
    }

    // Print method
    public String print() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodeTest Details:\n");
        sb.append(String.format("  Code Quality: %d\n", codeQuality));
        sb.append(String.format("  Probability of Success: %d%%\n", probabilityOfSuccess));

        if (review != null) {
            sb.append("  Review:\n");
            sb.append(String.format("    Feedback: %s\n", review.getFeedback()));
        } else {
            sb.append("  Review: <nil>\n");
        }

        if (security != null) {
            sb.append("  Security:\n");
            sb.append(String.format("    Low Severity: %d\n", security.getLowSeverity()));
            sb.append(String.format("    Medium Severity: %d\n", security.getMediumSeverity()));
            sb.append(String.format("    High Severity: %d\n", security.getHighSeverity()));
            sb.append(String.format("    Critical Severity: %d\n", security.getCriticalSeverity()));
        } else {
            sb.append("  Security: <nil>\n");
        }

        if (solid != null) {
            sb.append("  SOLID Scores:\n");
            sb.append(String.format("    Single Responsibility Principle: %d\n", solid.getSingleResponsibilityScore()));
            sb.append(String.format("    Open/Closed Principle: %d\n", solid.getOpenClosedScore()));
            sb.append(String.format("    Liskov Substitution Principle: %d\n", solid.getLiskovSubstitutionScore()));
            sb.append(String.format("    Interface Segregation Principle: %d\n", solid.getInterfaceSegregationScore()));
            sb.append(String.format("    Dependency Inversion Principle: %d\n", solid.getDependencyInversionScore()));
        } else {
            sb.append("  SOLID Scores: <nil>\n");
        }

        return sb.toString();
    }
}

