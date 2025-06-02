package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostUserRequest(
        String mode,
        String personalLastName,
        String personalFirstName,
        String personalMiddleName,
        String personalPhoneNumber,
        String personalNumberOfPassport,
        String personalAddress,
        String citizenLastName,
        String citizenFirstName,
        String citizenMiddleName,
        String citizenBirthDate,
        String citizenNumberOfPassport,
        String citizenGender,
        String citizenAddress,
        String dateOfMarriage,
        String newLastName,
        String anotherPersonLastName,
        String anotherPersonFirstName,
        String anotherPersonMiddleName,
        @JsonProperty("birth_of_anotoherPerson")
        String birthOfAnotoherPerson,
        String anotherPersonPassport,
        @JsonProperty("birth_place")
        String birthPlace,
        @JsonProperty("birth_mother")
        String birthMother,
        @JsonProperty("birth_father")
        String birthFather,
        @JsonProperty("death_dateOfDeath,")
        String deathDateOfDeath,
        @JsonProperty("death_placeOfDeath")
        String deathPlaceOfDeath) {
}
