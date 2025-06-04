package org.senla.eu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record PostProcessRequest(
        @JsonProperty("action")
        String action,
        @JsonProperty("applId")
        Integer applId,
        @JsonProperty("staffid")
        Integer staffid) {
}
