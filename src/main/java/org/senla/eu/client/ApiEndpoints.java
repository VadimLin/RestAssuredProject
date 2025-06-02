package org.senla.eu.client;

import lombok.Getter;

@Getter
public class ApiEndpoints {
    public static final String GET_APPLICATION_ENDPOINT = "/getApplications";
    public static final String POST_ADMIN_ENDPOINT = "/sendAdminRequest";
    public static final String POST_USER_ENDPOINT = "/sendUserRequest";
    public static final String GET_APP_STATUS_ENDPOINT = "/getApplStatus";
    public static final String POST_CHANGE_STATUS_ENDPOINT = "/requestProcess";
}
