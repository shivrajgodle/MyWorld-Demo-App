package com.kpit.myworld.candidate.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CandidateDto {

    private Long candidate_id;
    private String firstName;
    private String lastName;
    private String personalEmail;
    private String mobileNumber;
    private String departmentName;

}
