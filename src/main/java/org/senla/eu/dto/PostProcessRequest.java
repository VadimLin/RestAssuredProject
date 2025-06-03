package org.senla.eu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public record PostProcessRequest(
        @JsonProperty("action")
        String action,
        @JsonProperty("applid")
        Integer applId,
        @JsonProperty("staffid")
        Integer staffId) {
}
