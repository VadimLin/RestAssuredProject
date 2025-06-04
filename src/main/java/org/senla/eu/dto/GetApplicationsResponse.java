package org.senla.eu.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;


import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetApplicationsResponse {

    private String total;
    private List<ApplicationData> data;
    private String requestId;

}
