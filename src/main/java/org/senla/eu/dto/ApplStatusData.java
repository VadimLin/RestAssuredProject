package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplStatusData {
    @JsonProperty("dateofapplication")
    private String dateOfApplication;
    @JsonProperty("kindOfApplication")
    private String kindOfApplication;

    @JsonProperty("statusofapplication")
    private String statusOfApplication;
}
