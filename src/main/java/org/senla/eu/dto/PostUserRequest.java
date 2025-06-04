package org.senla.eu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PostUserRequest(
        @JsonProperty("mode")
        String mode,
        @JsonProperty("personalFirstName")
        String personalFirstName,
        @JsonProperty("personalLastName")
         String personalLastName,
        @JsonProperty("personalMiddleName")
        String personalMiddleName,
        @JsonProperty("personalNumberOfPassport")
        String personalNumberOfPassport,
        @JsonProperty("personalPhoneNumber")
         String personalPhoneNumber,
        @JsonProperty("personalAddress")
         String personalAddress,
        @JsonProperty("anotherPersonFirstName")
         String anotherPersonFirstName,
        @JsonProperty("anotherPersonLastName")
         String anotherPersonLastName,
        @JsonProperty("anotherPersonMiddleName")
         String anotherPersonMiddleName,
        @JsonProperty("anotherPersonPassport")
         String anotherPersonPassport,
        @JsonProperty("birth_of_anotoherPerson")
         String birthOfAnotherPerson,
        @JsonProperty("birth_place")
         String birthPlace,
        @JsonProperty("birth_father")
         String birthFather,
        @JsonProperty("birth_mother")
         String birthMother,
        @JsonProperty("birth_grandpa")
         String birthGrandpa,
        @JsonProperty("birth_grandma")
         String birthGrandma,
        @JsonProperty("newLastName")
         String newLastName,
        @JsonProperty("citizenFirstName")
         String citizenFirstName,
        @JsonProperty("citizenLastName")
         String citizenLastName,
        @JsonProperty("citizenMiddleName")
         String citizenMiddleName,
        @JsonProperty("citizenBirthDate")
         String citizenBirthDate,
        @JsonProperty("citizenNumberOfPassport")
         String citizenNumberOfPassport,
        @JsonProperty("citizenGender")
         String citizenGender,
        @JsonProperty("citizenAddress")
         String citizenAddress,
        @JsonProperty("dateOfMarriage")
         String dateOfMarriage,
        @JsonProperty("death_dateOfDeath")
         String deathDateOfDeath,
        @JsonProperty("death_placeOfDeath")
         String deathPlaceOfDeath) {
}
