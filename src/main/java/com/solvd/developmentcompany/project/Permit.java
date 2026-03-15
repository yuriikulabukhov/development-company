package com.solvd.developmentcompany.project;

import com.solvd.developmentcompany.interfaces.Approvable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Permit implements Approvable {
    private String permitNumber;
    private Boolean approved;
    private final Integer maxPeriod = 365;
    private static final Logger LOGGER = LoggerFactory.getLogger(Permit.class);

    public Permit(String permitNumber, Boolean approved) {
        this.permitNumber = permitNumber;
        this.approved = approved;
    }

    public String getPermitNumber() {return permitNumber;}

    public void setPermitNumber(String permitNumber) {this.permitNumber = permitNumber;}

    public Boolean getApproved() {return approved;}

    public void setApproved(Boolean approved) {this.approved = approved;}


    @Override
    public void approve() {
        this.approved = true;
        LOGGER.info("Permit " + permitNumber + " has been approved");
    }

    @Override
    public void reject() {
        this.approved = false;
        LOGGER.warn("Permit " + permitNumber + " has been rejected");
    }

    @Override
    public boolean isApproved() {return approved;}

    @Override
    public String getApprovalStatus() {
        return approved ? "Approved" : "Rejected";
    }

    public final Integer getMaxPeriod() {
        return maxPeriod;
    }

}
