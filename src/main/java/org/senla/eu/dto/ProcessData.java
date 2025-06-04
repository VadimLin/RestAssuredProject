package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessData {
    @JsonProperty("applicationid")
    private Integer applicationId;
    @JsonProperty("citizenid")
    private Integer citizenId;
    @JsonProperty("applicantid")
    private Integer applicantId;
    @JsonProperty("staffid")
    private Integer staffid;
    @JsonProperty("dateofapplication")
    private String dateOfApplication;
    @JsonProperty("kindofapplication")
    private String kindOfApplication;
    @JsonProperty("statusofapplication")
    private String statusOfApplication;
    private String channel;
    private String image;
}
