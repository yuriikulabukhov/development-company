package com.solvd.developmentcompany.interfaces;

public interface Approvable {
    void approve();
    void reject();
    boolean isApproved();
    String getApprovalStatus();
}
