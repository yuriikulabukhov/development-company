package com.solvd.developmentcompany.common;

public enum BuildStatusEnum {
    PLANNED("Planned", 0),
    IN_PROGRESS("In Progress", 50),
    COMPLETED("Completed", 100);

    private final String displayName;
    private final int progressPercent;

    BuildStatusEnum(String displayName, int progressPercent) {
        this.displayName = displayName;
        this.progressPercent = progressPercent;
    }

    public String getDisplayName() { return displayName; }

    public boolean isActive() { return progressPercent >= 0; }

}
