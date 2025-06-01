package org.senla.eu.client;

import lombok.Getter;

@Getter
public class ApiEndpoints {
    public static final String GETAPPLICATIONENPOINT = "/getApplications";
    public static final String POSTADMINENDPOINT = "/sendAdminRequest";
    public static final String POSTUSERENDPOINT = "/sendUserRequest";
    public static final String GETAPPSTATUSENDPOINT = "getApplStatus/";
    public static final String POSTCHANGESTATUSENPOINT= "/requestProcess";
}
