package org.senla.eu.dto;


import com.fasterxml.jackson.annotation.JsonProperty;



public record PostAdminRequest(
                               @JsonProperty("personalLastName")
                               String personalLastName,
                               @JsonProperty("personalFirstName")
                               String personalFirstName,
                               @JsonProperty("personalMiddleName")
                               String personalMiddleName,
                               @JsonProperty("personalPhoneNumber")
                               String personalPhoneNumber,
                               @JsonProperty("personalNumberOfPassport")
                               String personalNumberOfPassport,
                               @JsonProperty("dateofbirth")
                               String dateOfBirth) {
}
