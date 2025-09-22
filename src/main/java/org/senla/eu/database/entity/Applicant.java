package org.senla.eu.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    private Integer applicantId;
    private String surname;
    private String name;
    private String middleName;
    private String passportNumber;
    private String phoneNumber;
    private String registrationAddress;
}
