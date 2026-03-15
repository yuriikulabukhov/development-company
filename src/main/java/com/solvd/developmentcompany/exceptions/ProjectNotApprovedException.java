package com.solvd.developmentcompany.exceptions;

public class ProjectNotApprovedException extends RuntimeException {
    public ProjectNotApprovedException(String message) {
        super(message);
    }
}
