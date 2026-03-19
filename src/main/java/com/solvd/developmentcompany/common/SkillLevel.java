package com.solvd.developmentcompany.common;

public enum SkillLevel {
    JUNIOR("Junior", 1, 1.0),
    MIDDLE("Middle", 3, 1.3),
    SENIOR("Senior", 5, 1.6);

    private final String title;
    private final int minYearsExperience;
    private final double salaryMultiplier;  // multiplies base salary

    SkillLevel(String title, int minYearsExperience, double salaryMultiplier) {
        this.title = title;
        this.minYearsExperience = minYearsExperience;
        this.salaryMultiplier = salaryMultiplier;
    }

    public double calculateSalary(double baseSalary) {
        return baseSalary * salaryMultiplier;
    }

    public String getTitle() { return title; }
    public int getMinYearsExperience() { return minYearsExperience; }
    public double getSalaryMultiplier() { return salaryMultiplier; }
}
