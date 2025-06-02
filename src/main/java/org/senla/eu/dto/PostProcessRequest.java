package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostProcessRequest(
        @JsonProperty("applid")
        Integer applId,
        Integer staffId,
        String action) {
}
